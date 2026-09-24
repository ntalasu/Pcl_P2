PROGRAM TestNestedHashtable;

TYPE
    NestedTable = HASHTABLE [integer] OF HASHTABLE [char] OF real;

VAR
    nestedVar : HASHTABLE [boolean] OF HASHTABLE [integer] OF string;

BEGIN
END.