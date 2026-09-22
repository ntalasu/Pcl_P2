import java.util.HashSet;

public class TestSets
{

    private static class digits extends HashSet<Integer> {}
    private static class letters extends HashSet<Character> {}

    private static HashSet<Integer> nameddigits;
    private static HashSet<Integer> unnameddigits;
    private static HashSet<Boolean> flags;

    public static void main(String[] args)
    {
        System.out.println("Done!");
    }
}
