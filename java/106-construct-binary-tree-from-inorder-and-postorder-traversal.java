import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, new int[]{7, 11, 2, 6, 5, 13, 8, 4, 1}, new int[]{7, 2, 11, 6, 13, 1, 4, 8, 5},  true);
        test(2, new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 3, 2, 6, 5, 4},   true);
    }

    public static void test(int testNo, int[] preorder, int[] inorder, boolean expectValue) {
        //System.out.print(l1.toString() + ", " + l2.toString());
        TreeNode res = buildTree(preorder, inorder);

        for(String x : res.levelOrderSerialization()) {
            System.out.print(x + " ");
        }
        System.out.println("");
//        if (res == expectValue) {
//            System.out.println(testNo + ": Pass");
//        } else {
//            System.out.println(testNo + ": Fail");
//            System.out.println("Expect " + expectValue + ", Return " + res);
//        }
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length == 0) return null;
        if(postorder.length == 1) return new TreeNode(postorder[0]);
        TreeNode node = new TreeNode(postorder[postorder.length - 1]);
        int i = postorder.length - 1;
        while(inorder[i] != postorder[postorder.length - 1]) i--;
        node.right = buildTree(subArray(inorder, i + 1, inorder.length - 1), subArray(postorder, i, postorder.length - 2));
        node.left = buildTree(subArray(inorder, 0, i - 1), subArray(postorder, 0, i - 1));
        return node;
    }
    public static int[] subArray(int[] array, int start, int end) {
        return start > end? new int[]{} : Arrays.copyOfRange(array, start, end + 1);
    }
}