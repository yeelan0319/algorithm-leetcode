import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, new TreeNode(new String[]{"5","4","7","2","#","6","8","1","3"}), new TreeNode(new String[]{"5","4","7","2","#","6","8","1","3"}), true);
        test(2, new TreeNode(new String[]{"1","2"}), new TreeNode(new String[]{"1","1"}), false);
        test(3, new TreeNode(new String[]{"-2147483648","-2147483648"}), new TreeNode(new String[]{"-2147483648"}), false);
        test(4, new TreeNode(new String[]{"-2147483648","-2147483648"}), new TreeNode(new String[]{"-2147483648","-2147483648"}), true);
        test(5, null, null, true);
    }

    public static void test(int testNo, TreeNode p, TreeNode q, boolean expectValue) {
        //System.out.print(l1.toString() + ", " + l2.toString());
        boolean res = isSameTree(p, q);

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

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p == null || q == null) {
            return false;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}