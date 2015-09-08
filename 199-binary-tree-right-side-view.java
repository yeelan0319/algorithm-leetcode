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
        List<Integer> res = rightSideView(root);
        for(int i : res){
            System.out.print(i + ",");
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
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        LinkedList<TreeNode> p = new LinkedList<TreeNode>();
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(q.size() > 0) {
            LinkedList<TreeNode> tmp = p;
            p = q;
            q = tmp;
            res.add(p.getLast().val);
            while(p.size() > 0) {
                TreeNode node = p.removeFirst();
                if(node.left != null) {
                    q.add(node.left);
                }
                if(node.right != null) {
                    q.add(node.right);
                }
            }
        }
        return res;
    }
}