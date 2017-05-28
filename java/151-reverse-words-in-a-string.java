import java.util.*;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test("the sky is blue", "blue is sky the");
        test("the sky is    blue", "blue is sky the");
        test("   the sky is blue     ", "blue is sky the");
        test("   ", "");
    }

    public static void test(String s, String expectValue) {
        String res = reverseWords(s);
        if (res.equals(expectValue)) {
            System.out.println(s + ": Pass");
        } else {
            System.out.println(s + ": Fail");
            System.out.println("Expect " + expectValue + ", Return " + res);
        }
    }

    public static String reverseWords(String s) {
        if(s == null) return null;
        if(s.length() == 0) return "";
        String str = s.trim();
        StringBuilder sb = new StringBuilder();
        int[] wordIndex = findNextWordIndex(str, str.length() - 1);
        while(Arrays.equals(wordIndex, new int[]{-1, -1}) == false) {
            sb.append(str.substring(wordIndex[0], wordIndex[1]));
            sb.append(" ");
            wordIndex = findNextWordIndex(str, wordIndex[0] - 1);
        }
        return sb.toString().trim();
    }
    public static int[] findNextWordIndex(String str, int pos) {
        int start, end;
        while(pos >= 0 && str.charAt(pos) == ' ')
            pos--;
        //注意此处条件，有可能传入的pos == -1，一开始写的pos == 0的条件是不对的
        if(pos < 0) {
            return new int[]{-1, -1};
        }
        else{
        		// substring的end是需要的string结束的位置 + 1
            end = pos + 1;
        }
        while(pos >= 0 && str.charAt(pos) != ' ')
            pos--;
        start = pos + 1;
        return new int[]{start, end};
    }
}
