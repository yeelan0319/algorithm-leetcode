import java.util.*;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test("abcdef", "abc", 0);
        test("abcdef", "bc", 1);
        test("abcdefa", "fa", 5);
        test("abcdef", "abce", -1);
        test("   ", "abc", -1);
        test("","", 0);
    }

    public static void test(String s, String t, int expectValue) {
        int res = strStr(s, t);
        if (res == expectValue) {
            System.out.println(s + ": Pass");
        } else {
            System.out.println(s + ": Fail");
            System.out.println("Expect " + expectValue + ", Return " + res);
        }
    }

    public static int strStr(String haystack, String needle) {
        if(haystack == null || needle == null) return -1;
        if(needle.length() == 0) return 0;
        if(haystack.length() == 0) return -1;
        for(int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if(haystack.charAt(i) == needle.charAt(0)) {
                int j = 1;
                while(j < needle.length() && haystack.charAt(i + j) == needle.charAt(j)) j++;
                if(j == needle.length()) {
                    return i;
                }
            }
        }
        return -1;
    }
}
