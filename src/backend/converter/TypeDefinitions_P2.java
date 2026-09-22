package backend.converter;

import intermediate.antlr4.Pcl_P2Parser.*;

import intermediate.type.Typespec_P2;
import intermediate.type.Typespec_P2.Form;

import static intermediate.type.Typespec_P2.Form.*;

public class TypeDefinitions_P2 extends Converter_P2
{
    boolean first = true;
    
    Object typeDefinition(TypeDefinitionContext ctx) 
    { 
        IdentifierContext typeIdCtx = ctx.identifier();
        Typespec_P2 typespec = typeIdCtx.typespec;
        Form form = typespec.getForm();
        
        if (form == ENUMERATED)
        {
            String typeName = typeIdCtx.entry.getName();
            TypeSpecificationContext typespecCtx = ctx.typeSpecification();
            
            if (first)
            {
                code.emitLine();
                first = false;
            }

            code.emitStart();
            code.emit("private static enum " + typeName);
            
            visit(typespecCtx);
        }
        else if (form == SET)
        {
            String typeName = typeIdCtx.entry.getName();
            if (first)
            {
                code.emitLine();
                first = false;
            }

            code.emitLine("private static class " + typeName
                          + " extends HashSet<"
                          + javaElementTypeName(typespec.getSetElementType())
                          + "> {}");
        }

        else if (form == HASHTABLE)
        {
            String typeName = typeIdCtx.entry.getName();
            if (first)
            {
                code.emitLine();
                first = false;
            }

            code.emitLine("private static class " + typeName
                    + " extends " + javaHashtableTypeName(typespec)
                    + " {}");
        }
        
        return null;
    }

    private String javaHashtableTypeName(Typespec_P2 typespec)
    {
        if (typespec.getForm() == HASHTABLE)
        {
            return "HashMap<"
                    + javaHashtableTypeName(typespec.getHashtableKeyType())
                    + ", "
                    + javaHashtableTypeName(typespec.getHashtableElementType())
                    + ">";
        }
        else if (typespec.getForm() == SET)
        {
            return "HashSet<"
                    + javaElementTypeName(typespec.getSetElementType()) + ">";
        }
        else
        {
            return javaElementTypeName(typespec);
        }
    }

    private String javaElementTypeName(Typespec_P2 typespec)
    {
        if (typespec.getForm() == SUBRANGE)
        {
            typespec = typespec.baseType();
        }

        if (typespec.getIdentifier() != null)
        {
            String typeName = typespec.getIdentifier().getName();
            String javaName = typeNameTable.get(typeName);
            if (javaName != null)
            {
                return boxed(javaName);
            }
            return typeName;
        }

        return "Integer";
    }

    private String boxed(String typeName)
    {
        switch (typeName)
        {
            case "int": return "Integer";
            case "double": return "Double";
            case "boolean": return "Boolean";
            case "char": return "Character";
            default: return typeName;
        }
    }
    
    Object enumeratedType(EnumeratedTypeContext ctx)
    {
        String separator = " {";
        
        for (IdentifierContext constIdCtx : 
                                    ctx.identifier())
        {
            String name = constIdCtx.entry.getName();
            code.emit(separator + name);
            separator = ", ";
        }

        code.emitEnd("};");
        return null;
    }
}
