import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
//        test(1, "23", 1);
//        test(2, "79", 1);
//        test(3, "503", 1);
        test(4, "51", 1);
    }

    public static void test(int testNo, String digits, int expectValue) {
        //System.out.print(l1.toString() + ", " + l2.toString());
        List<String> res = letterCombinations(digits);

        for(String s : res) {
            System.out.println(s);
        }
        System.out.println("");
//        if (res == expectValue) {
//            System.out.println(testNo + ": Pass");
//        } else {
//            System.out.println(testNo + ": Fail");
//            System.out.println("Expect " + expectValue + ", Return " + res);
//        }
    }

    static List<List<Character>> dic = new ArrayList<List<Character>>() {
        {
            add(new ArrayList<Character>(Arrays.asList(' ')));
            add(new ArrayList<Character>());
            add(new ArrayList<Character>(Arrays.asList('a', 'b', 'c')));
            add(new ArrayList<Character>(Arrays.asList('d', 'e', 'f')));
            add(new ArrayList<Character>(Arrays.asList('g', 'h', 'i')));
            add(new ArrayList<Character>(Arrays.asList('j', 'k', 'l')));
            add(new ArrayList<Character>(Arrays.asList('m', 'n', 'o')));
            add(new ArrayList<Character>(Arrays.asList('p', 'q', 'r', 's')));
            add(new ArrayList<Character>(Arrays.asList('t', 'u', 'v')));
            add(new ArrayList<Character>(Arrays.asList('w', 'x', 'y', 'z')));
        }
    };

    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if(digits.length() == 0) return res;
        StringBuilder sb = new StringBuilder();
        letterCombinationsHelper(digits, sb, res, 0);
        return res;
    }
    public static void letterCombinationsHelper(String digits, StringBuilder sb, List<String> res, int begin) {
        if(begin == digits.length()) {
            res.add(sb.toString());
            return;
        }
        int digit = Integer.parseInt(digits.charAt(begin) + "");
        for(char c : dic.get(digit)) {
            sb.append(c);
            letterCombinationsHelper(digits, sb, res, begin + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}