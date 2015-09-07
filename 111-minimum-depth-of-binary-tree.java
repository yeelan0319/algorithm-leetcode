import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, new TreeNode(new String[]{"1","2","3","#","#","4","#","#","5"}), 2);
        test(2, new TreeNode(new String[]{"3","9","20","#","#","15","7"}), 2);
        test(3, new TreeNode(new String[]{"1", "2"}), 2);
        test(4, null, 0);
    }

    public static void test(int testNo, TreeNode head, int expectValue) {
        //System.out.print(l1.toString() + ", " + l2.toString());
        int res = minDepth(head);

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
   	//本以为这道题很简单，其实陷阱很多。
   	//首先就是关于深度的定义，必须是从根节点到叶子节点的高度才是深度，所以就算是最大深度混过去了（因为当时选择走最远，也就是说到叶子节点）
   	//但是最小深度的时候就体现出来必须判断到叶子节点的条件，也就是左右子节点都是空
   	//其次陷阱之二就是base case其实还包含了根节点为空的情况，不能忘记判断 
    public static int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        int left = root.left != null? minDepth(root.left) : Integer.MAX_VALUE;
        int right = root.right != null? minDepth(root.right) : Integer.MAX_VALUE;
        return Math.min(left, right) + 1;
    }
}