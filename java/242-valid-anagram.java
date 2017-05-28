import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, "anagram", "nagaram", true);
        test(2, "rat", "car", false);
    }

    public static void test(int testNo, String s, String t, boolean expectValue) {
        boolean res = isAnagram(s, t);

//        for(char[] row : board) {
//            for(char c : row) {
//                System.out.print(c + " ");
//            }
//            System.out.println("");
//        }
//        System.out.println("");
        if (res == expectValue) {
            System.out.println(testNo + ": Pass");
        } else {
            System.out.println(testNo + ": Fail");
            System.out.println("Expect " + expectValue + ", Return " + res);
        }
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        for(char c : s.toCharArray()) {
            count.put(c, count.containsKey(c)? count.get(c) + 1 : 1);
        }
        for(char c : t.toCharArray()) {
            if(!count.containsKey(c) || count.get(c) - 1 < 0) {
                return false;
            }
            else {
                count.put(c, count.get(c) - 1);
            }
        }
        return true;
    }
}