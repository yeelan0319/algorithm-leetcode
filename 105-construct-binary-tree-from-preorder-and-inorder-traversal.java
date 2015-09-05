import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, new int[]{5, 6, 11, 7, 2, 8, 13, 4, 1}, new int[]{7, 11, 2, 6, 5, 13, 8, 4, 1}, true);
        test(2, new int[]{4, 2, 1, 3, 5, 6}, new int[]{1, 2, 3, 4, 5, 6},  true);
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

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        if(preorder.length == 1) {
            TreeNode node = new TreeNode(preorder[0]);
            return node;
        }
        TreeNode node = new TreeNode(preorder[0]);
        int i = 0;
        while(inorder[i] != preorder[0]) i++;
        node.left = buildTree(subArray(preorder, 1, i), subArray(inorder, 0, i - 1));
        node.right = buildTree(subArray(preorder, i + 1, preorder.length - 1), subArray(inorder, i + 1, inorder.length - 1));
        return node;
    }
    public static int[] subArray(int[] array, int start, int end) {
        return start > end? new int[]{} : Arrays.copyOfRange(array, start, end + 1);
    }
}