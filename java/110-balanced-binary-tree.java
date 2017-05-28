import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, new TreeNode(new String[]{"1","2","3","#","#","4","#","#","5"}), false);
        test(2, new TreeNode(new String[]{"3","9","20","#","#","15","7"}), true);
        test(3, new TreeNode(new String[]{"1", "2"}), true);
        test(4, null, true);
    }

    public static void test(int testNo, TreeNode head, boolean expectValue) {
        //System.out.print(l1.toString() + ", " + l2.toString());
        boolean res = isBalanced(head);

//        for(String x : res.levelOrderSerialization()) {
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
    public static boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return isBalancedHelper(root) != -1;
    }
    public static int isBalancedHelper(TreeNode root) {
        if(root == null) return 0;
        int left = isBalancedHelper(root.left);
        int right = isBalancedHelper(root.right);
        if(left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        else {
            return Math.max(left, right) + 1;
        }
    }
}