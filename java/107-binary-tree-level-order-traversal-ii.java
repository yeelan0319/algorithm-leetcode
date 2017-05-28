import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, new TreeNode(new String[]{"1","2","3","#","#","4","#","#","5"}), null);
        test(2, new TreeNode(new String[]{"3","9","20","#","#","15","7"}), null);
        test(3, new TreeNode(new String[]{"1","2","3","4","#","#","5"}), null);
    }

    public static void test(int testNo, TreeNode root, List<List<Integer>> expectValue) {
        //System.out.print(l1.toString() + ", " + l2.toString());
        List<List<Integer>> res = levelOrderBottom(root);

        for(List<Integer> list : res) {
            for(int x : list) {
                System.out.print(x + " ");
            }
            System.out.println("");
        }
        System.out.println("");
//        if (res == expectValue || res.equals(expectValue)) {
//            System.out.println(testNo + ": Pass");
//        } else {
//            System.out.println(testNo + ": Fail");
//            System.out.println("Expect " + expectValue.val + ", Return " + res.val);
//        }
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;

        LinkedList<TreeNode> source = new LinkedList<TreeNode>();
        LinkedList<TreeNode> target = new LinkedList<TreeNode>();
        target.add(root);
        while(target.size() > 0) {
            List<Integer> row = new ArrayList<Integer>();
            LinkedList<TreeNode> temp = source;
            source = target;
            target = temp;
            while(source.size() > 0) {
                TreeNode node = source.removeFirst();
                row.add(node.val);
                if(node.left != null) {
                    target.add(node.left);
                }
                if(node.right != null) {
                    target.add(node.right);
                }
            }
            res.add(0, row);
        }
        return res;
    }
}