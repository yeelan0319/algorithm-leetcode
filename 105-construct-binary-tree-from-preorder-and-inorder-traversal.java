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
        return buildTreeHelper(preorder, 0, inorder, 0, preorder.length);
    }
    public static TreeNode buildTreeHelper(int[] preorder, int prestart, int[] inorder, int instart, int length) {
        if(length <= 0) return null;
        if(length == 1) return new TreeNode(preorder[prestart]);
        TreeNode node = new TreeNode(preorder[prestart]);
        int i = 0;
        while (inorder[instart + i] != preorder[prestart]) i++;
        node.left = buildTreeHelper(preorder, prestart + 1, inorder, instart, i);
        node.right = buildTreeHelper(preorder, prestart + i + 1, inorder, instart + i + 1, length - i - 1);
        return node;
    }
}