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
        int res = sumNumbers(root);

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
        if (res == expectValue) {
            System.out.println(testNo + ": Pass");
        } else {
            System.out.println(testNo + ": Fail");
            System.out.println("Expect " + expectValue + ", Return " + res);
        }
    }
    static int sum = 0;
    public static int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        sum = 0;
        sumNumbersHelper(root, 0);
        return sum;
    }
    public static void sumNumbersHelper(TreeNode root, int parentPath) {
        int x = parentPath * 10 + root.val;
        if(root.left == null && root.right == null) {
            sum += x;
            return;
        }
        if(root.left != null) {
            sumNumbersHelper(root.left, x);
        }
        if(root.right != null) {
            sumNumbersHelper(root.right, x);
        }
    }
}