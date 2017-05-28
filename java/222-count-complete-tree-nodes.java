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
        test(4, new TreeNode(new String[]{"1","2","1","2","1","2","1","2","1"}), 9);
        test(5, null, 0);
    }

    public static void test(int testNo, TreeNode root, int expectValue) {
        //System.out.print(l1.toString() + ", " + l2.toString());
        int res = countNodes(root);

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
    //注意Java中<<的优先级很低，是最后做的。所以如果1<<(h - 1) + xxx的话，是会在位操作前先执行后面的加法
   	//另外注意高度不要弄错
    public static int countNodes(TreeNode root) {
        if(root == null) return 0;
        int h = height(root);
        return height(root.right) == (h - 1)? (1<<h - 1) + countNodes(root.right) : (1<<h - 2) + countNodes(root.left);
    }
    public static int height(TreeNode root) {
        if(root == null) return 0;
        //由于是满树，所以高度其实可以不用Math.max去搜索整个的树，而是只要考虑最左支就可以了。否则会出现超时错误
        return height(root.left) + 1;
    }
}