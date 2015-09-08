import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, new TreeNode(new String[]{"1","2","3"}), 3);
        test(2, new TreeNode(new String[]{"1"}), 1);
        test(3, new TreeNode(new String[]{"1", "2"}), 2);
        test(4, new TreeNode(new String[]{"4","2","7","1","3","6","9"}), 9);
        test(5, null, 0);
    }

    public static void test(int testNo, TreeNode root, int expectValue) {
        //System.out.print(l1.toString() + ", " + l2.toString());
        TreeNode res = invertTree(root);

        if(res != null){
            for (String x : res.levelOrderSerialization()) {
                System.out.print(x + " ");
            }
        }
        else{
            System.out.print("[]");
        }
        System.out.println("");
//        if (res == expectValue) {
//            System.out.println(testNo + ": Pass");
//        } else {
//            System.out.println(testNo + ": Fail");
//            System.out.println("Expect " + expectValue + ", Return " + res);
//        }
    }
    public static TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}