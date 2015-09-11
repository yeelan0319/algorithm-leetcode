import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, "{{}}", true);
        test(2, "{[}]", false);
        test(3, "{[]}", true);
        test(4, "{[]}()", true);
        test(5, "{}}{()", false);
    }

    public static void test(int testNo, String s, boolean expectValue) {
        //System.out.print(l1.toString() + ", " + l2.toString());
       boolean res = isValid(s);

//        for(String s : res) {
//            System.out.println(s);
//        }
//        System.out.println("");
        if (res == expectValue) {
            System.out.println(testNo + ": Pass");
        } else {
            System.out.println(testNo + ": Fail");
            System.out.println("Expect " + expectValue + ", Return " + res);
        }
    }

    public static boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<Character>();
        char lastopen;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch(c){
                case '[':
                case '{':
                case '(':
                    stack.add(c);
                    break;
                case ']':
                    if(stack.size() > 0){
                        lastopen = stack.getLast();
                        if(lastopen == '[') {
                            stack.removeLast();
                            break;
                        }
                    }
                    return false;
                case '}':
                    if(stack.size() > 0){
                        lastopen = stack.getLast();
                        if(lastopen == '{') {
                            stack.removeLast();
                            break;
                        }
                    }
                    return false;
                case ')':
                    if(stack.size() > 0){
                        lastopen = stack.getLast();
                        if(lastopen == '(') {
                            stack.removeLast();
                            break;
                        }
                    }
                    return false;
                default:
                    return false;
            }
        }
        return stack.size() == 0;
    }
}