import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, new TreeNode(new String[]{"1","2","3"}), 25);
        test(2, new TreeNode(new String[]{"3"}), 3);
        test(3, new TreeNode(new String[]{"1", "2"}), 12);
        test(4, null, 0);
    }

    public static void test(int testNo, TreeNode root, int expectValue) {
        //System.out.print(l1.toString() + ", " + l2.toString());
        List<String> res = binaryTreePaths(root);
        for(String str : res){
            System.out.println(str);
        }
        System.out.println("");

//        for(TreeNode root : res) {
//            if(root != null){
//                for (String x : root.levelOrderSerialization()) {
//                    System.out.print(x + " ");
//                }
//            }
//            else{
//                System.out.print("[]");
//            }
//            System.out.println("");
//        }
//        System.out.println("");
//        if (res == expectValue) {
//            System.out.println(testNo + ": Pass");
//        } else {
//            System.out.println(testNo + ": Fail");
//            System.out.println("Expect " + expectValue + ", Return " + res);
//        }
    }
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if(root == null) return res;
        binaryTreePathsHelper(root, res, "");
        return res;
    }
    public static void binaryTreePathsHelper(TreeNode root, List<String> res, String parentPath) {
        if(root.left == null && root.right == null) {
            res.add(parentPath + root.val);
            return;
        }
        if(root.left != null) {
            binaryTreePathsHelper(root.left, res, parentPath + root.val + "->");
        }
        if(root.right != null) {
            binaryTreePathsHelper(root.right, res, parentPath + root.val + "->");
        }
    }
}