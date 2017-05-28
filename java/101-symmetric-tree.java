import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, new TreeNode(new String[]{"1","2","2","3","4","4","3"}), true);
        test(2, new TreeNode(new String[]{"1","1", "#"}), false);
        test(3, new TreeNode(new String[]{"-2147483648","-2147483648"}), false);
        test(4, new TreeNode(new String[]{"2147483647","-2147483648", "-2147483648"}), true);
        test(5, null, true);
    }

    public static void test(int testNo, TreeNode root, boolean expectValue) {
        //System.out.print(l1.toString() + ", " + l2.toString());
        boolean res = isSymmetric(root);

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

    public static boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetricHelper(root.left, root.right);
    }
    public static boolean isSymmetricHelper(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) {
            return true;
        }
        if(t1 == null || t2 == null) {
            return false;
        }
        return t1.val == t2.val && isSymmetricHelper(t1.left, t2.right) && isSymmetricHelper(t1.right, t2.left);
    }
}