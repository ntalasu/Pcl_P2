import java.util.HashSet;
import java.util.HashMap;

public class TestHashtables
{

    private static class IntToString extends HashMap<Integer, String> {}
    private static class CharToReal extends HashMap<Character, Double> {}
    private static class BoolToInt extends HashMap<Boolean, Integer> {}

    private static HashMap<Integer, Character> table1;
    private static HashMap<Character, Boolean> table2;
    private static HashMap<Boolean, Double> table3;

    public static void main(String[] args)
    {
        System.out.println("Done!");
    }
}
