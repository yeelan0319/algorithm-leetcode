import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, new TreeNode(new String[]{"1","2","3","#","#","4","#","#","5"}), 4);
        test(2, new TreeNode(new String[]{"3","9","20","#","#","15","7"}), 3);
        test(3, new TreeNode(new String[]{"1"}), 1);
    }

    public static void test(int testNo, TreeNode head, int expectValue) {
        //System.out.print(l1.toString() + ", " + l2.toString());
        int res = maxDepth(head);

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

    public static int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}