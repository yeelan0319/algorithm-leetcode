import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, new TreeNode(new String[]{"2","1","3"}), 2, 2);
        test(2, new TreeNode(new String[]{"1"}), 1, 1);
        test(3, new TreeNode(new String[]{"2", "1"}), 1, 1);
        test(4, new TreeNode(new String[]{"4","2","7","1","3","6","9"}), 4, 4);
        test(5, new TreeNode(new String[]{"2","0","33","#","1","25","40","#","#","11","31","34","45","10","18","29","32","#","36","43","46","4","#","12","24","26","30","#","#","35","39","42","44","#","48","3","9","#","14","22","#","#","27","#","#","#","#","38","#","41","#","#", "#","47","49","#","#","5","#","13","15","21","23","#","28","37","#","#","#","#","#","#","#","#","8","#","#","#","17","19","#","#","#","#","#","#","#","7","#","16","#","#","20","6"}), 25, 24);
    }

    public static void test(int testNo, TreeNode root, int k, int expectValue) {
        //System.out.print(l1.toString() + ", " + l2.toString());
        int res = kthSmallest(root, k);

//        if(res != null){
//            for (String x : res.levelOrderSerialization()) {
//                System.out.print(x + " ");
//            }
//        }
//        else{
//            System.out.print("[]");
//        }
//        System.out.println("");
        if (res == expectValue) {
            System.out.println(testNo + ": Pass");
        } else {
            System.out.println(testNo + ": Fail");
            System.out.println("Expect " + expectValue + ", Return " + res);
        }
    }
    public static int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        stack.add(root);
        root = root.left;
        while(stack.size() > 0 || root != null) {
            while(root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            k--;
            if(k == 0) break;
            root = root.right;
        }
        return root.val;
    }
}