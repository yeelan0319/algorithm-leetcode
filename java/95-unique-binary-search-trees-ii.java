import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, 3, 5);
        test(2, 2, 2);
        test(3, 1, 1);
        test(4, 0, 0);
    }

    public static void test(int testNo, int n, int expectValue) {
        //System.out.print(l1.toString() + ", " + l2.toString());
        List<TreeNode> res = generateTrees(n);

        for(TreeNode root : res) {
            for (String x : root.levelOrderSerialization()) {
                System.out.print(x + " ");
            }
            System.out.println("");
        }
        System.out.println("");
//        if (res == expectValue) {
//            System.out.println(testNo + ": Pass");
//        } else {
//            System.out.println(testNo + ": Fail");
//            System.out.println("Expect " + expectValue + ", Return " + res);
//        }
    }
    public static List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        return generateTreesHelper(1, n);
    }
    public static List<TreeNode> generateTreesHelper(int start, int end) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        if(start > end) {
            res.add(null);
            return res;
        }
        else if(start == end) {
            res.add(new TreeNode(start));
            return res;
        }
        else {
            for(int i = start; i < end + 1; i++) {
                List<TreeNode> leftres = generateTreesHelper(start, i - 1);
                List<TreeNode> rightres = generateTreesHelper(i + 1, end);
                for(TreeNode l : leftres) {
                    for(TreeNode r : rightres) {
                        TreeNode root = new TreeNode(i);
                        root.left = l;
                        root.right = r;
                        res.add(root);
                    }
                }
            }
            return res;
        }
    }
}