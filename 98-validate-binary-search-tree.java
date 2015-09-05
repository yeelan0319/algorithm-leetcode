import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, new TreeNode(new String[]{"5","4","7","2","#","6","8","1","3"}), true);
        test(2, new TreeNode(new String[]{"1","2"}), false);
        test(3, new TreeNode(new String[]{"1","#","2"}), true);
        test(4, new TreeNode(new String[]{"1","#","2","3"}), false);
        test(5, new TreeNode(new String[]{"-2147483648","-2147483648"}), false);
        test(6, new TreeNode(new String[]{"-2147483648"}), true);
    }

    public static void test(int testNo, TreeNode root, boolean expectValue) {
        //System.out.print(l1.toString() + ", " + l2.toString());
        boolean res = isValidBST(root);

//        for(int x : res) {
//            System.out.print(x + " ");
//        }
//        System.out.println("");
        if (res == expectValue) {
            System.out.println(testNo + ": Pass");
        } else {
            System.out.println(testNo + ": Fail");
            System.out.println("Expect " + expectValue + ", Return " + res);
        }
    }

    public static boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return isValidBSTHelper(root, (long)Integer.MIN_VALUE, (long)Integer.MAX_VALUE);
    }
    public static boolean isValidBSTHelper(TreeNode root, long min, long max) {
        if(root == null) return true;
        long val = (long)root.val;
        return val >= min && val <= max &&
                isValidBSTHelper(root.left, min, val - 1) && isValidBSTHelper(root.right, val + 1, max);
    }
}