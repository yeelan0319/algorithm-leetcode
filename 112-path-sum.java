import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, new TreeNode(new String[]{"5","4","8","11","#","13","4","7","2","#", "#","#","1"}), 22, true);
        test(2, new TreeNode(new String[]{"1","2"}), 1, false);
    }

    public static void test(int testNo, TreeNode root, int sum, boolean expectValue) {
        //System.out.print(l1.toString() + ", " + l2.toString());
        boolean res = hasPathSum(root, sum);

//        for(List<Integer> list : res) {
//            for(int x : list) {
//                System.out.print(x + " ");
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

    public static boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        return hasPathSumHelper(root, sum, 0);
    }
    public static boolean hasPathSumHelper(TreeNode root, int sum, int tmp) {
        if(root == null) {
            return false;
        }
        tmp += root.val;
        if(root.left == null && root.right == null && tmp == sum){
            return true;
        }
        else if(hasPathSumHelper(root.left, sum, tmp) || hasPathSumHelper(root.right, sum, tmp)) {
            return true;
        }
        else {
            return false;
        }
    }
}