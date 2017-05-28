import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static int completePath;

    public static void main(String[] args) {
        test(1, new TreeNode(new String[]{"1","2","3"}), 6);
        test(2, null, 0);
        test(3, new TreeNode(new String[]{"1","2","3","100","100"}), 202);
        test(4, new TreeNode(new String[]{"1","2","300","#","100","1","7"}), 410);
        test(5, new TreeNode(new String[]{"-100"}), -100);
        test(6, new TreeNode(new String[]{"2", "-1"}), 2);
    }

    public static void test(int testNo, TreeNode head, int expectValue) {
        //System.out.print(l1.toString() + ", " + l2.toString());
        int res = maxPathSum(head);

//        for(String x : head.levelOrderSerialization()) {
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
    public static int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        completePath = Integer.MIN_VALUE;
        maxPathSumHelper(root);
        return completePath;
    }
    public static int maxPathSumHelper(TreeNode root) {
        if(root == null) return 0;
        //这里之所以有Math.max是说如果子树的和小于0，就可以选择不要从这个子树开始。
        //因为题目的要求是可以从任何点开始到任何点结束
        int left = Math.max(0, maxPathSumHelper(root.left));
        int right = Math.max(0, maxPathSumHelper(root.right));
        completePath = Math.max(completePath, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}