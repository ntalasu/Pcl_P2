import java.util.HashSet;

public class TestSets
{
    private enum Color {
        RED, GREEN, BLUE, BLACK
    }

    public static class ColorSet extends HashSet<Color> {}
    private static class digits extends HashSet<Integer> {}
    private static class letters extends HashSet<Character> {}

    private static HashSet<Integer> smallNums;
    private static digits nameddigits;
    private static HashSet<Integer> unnameddigits;
    private static HashSet<Boolean> flags;

    public static void main(String[] args)
    {

        System.out.println("Done!");
    }
}
