import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, new TreeNode(new String[]{"5","4","8","11","#","13","4","7","2","#", "#","5","1"}), true);
        test(2, new TreeNode(new String[]{"1","2"}), false);
        test(3, new TreeNode(new String[]{"1","#","2","3"}), false);
    }

    public static void test(int testNo, TreeNode root, boolean expectValue) {
        //System.out.print(l1.toString() + ", " + l2.toString());
        List<Integer> res = postorderTraversal(root);

        for(int x : res) {
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

    public static List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if(root == null) return res;
		postorderTraversalHelper(root, res);
		return res;
	}
	public static void postorderTraversalHelper(TreeNode root, List<Integer> res) {
		if(root == null) return;
		postorderTraversalHelper(root.left, res);
		postorderTraversalHelper(root.right, res);
        res.add(root.val);
	}
}