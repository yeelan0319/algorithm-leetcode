import java.util.*;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test("A man, a plan, a canal: Panama.", true);
        test("race a car", false);
        test(".,", true);
        test("1a2", false);
    }

    public static void test(String s, boolean expectValue) {
        boolean res = isPalindrome(s);
        if (res == expectValue) {
            System.out.println(s + ": Pass");
        } else {
            System.out.println(s + ": Fail");
            System.out.println("Expect " + expectValue + ", Return " + res);
        }
    }

    public static boolean isPalindrome(String s) {
        if(s == null) return true;
        String str = s.toLowerCase();
        int start = 0;
        int end = s.length() - 1;

        while(start < end) {
            if(!Character.isJavaIdentifierPart(str.charAt(start))){
                start++;
            }
            else if(!Character.isJavaIdentifierPart(str.charAt(end))){
                end--;
            }
            else{
                if (str.charAt(start) != str.charAt(end)) {
                    return false;
                } else {
                    start++;
                    end--;
                }
            }
        }
        return true;
    }
}