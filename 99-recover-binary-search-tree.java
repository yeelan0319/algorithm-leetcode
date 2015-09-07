import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, new TreeNode(new String[]{"6","8","3","2","4","7","9","1","#","#", "5"}), false);
        test(2, new TreeNode(new String[]{"6","1","8","2","4","7","9","3","#","#", "5"}), false);
        test(3, new TreeNode(new String[]{"7","3","8","2","4","6","9","1","#","#", "5"}), false);
        test(4, new TreeNode(new String[]{"9","3","8","2","4","7","6","1","#","#", "5"}), false);
    }

    public static void test(int testNo, TreeNode head, boolean expectValue) {
        //System.out.print(l1.toString() + ", " + l2.toString());
        recoverTree(head);

        for(String x : head.levelOrderSerialization()) {
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
    /*
    把关于此题的分析写在这里。
    首先本题利用的是对于BST而言，inorder遍历之后会输出一个sorted array，所以如果BST中两个节点交换了位置，那么输出的array中必然有两处出错
    而它的结构一定是“大 小”这样的顺序
    第一个出现的大一定是错误的，但是第一个出现的小有可能是错误的，也有出错的元素还在后面。
    被交换的小的元素，可以通过最后一次出现的错误的小来确定。
    因此会有第一次找到错误的时候，把两个都放进去（以免实际发生交换的是两个相邻元素），然后如果后面还有出现错误，就更新后一个。

    但是这道题同样也是陷阱很多，
    比如：对于空子树而言，不应该更新pre；另外一个要注意的就是java里面没有指针这个概念，所以修改的时候只能改变指针指向的元素
    而不能修改原来传进来的指针究竟指向谁。
    */
    public static void recoverTree(TreeNode root) {
        if(root == null) return;
        List<TreeNode> res = new ArrayList<TreeNode>(2);
        recoverTreeHelper(root, null, res);
        int tmp = res.get(0).val;
        res.get(0).val = res.get(1).val;
        res.get(1).val = tmp;
    }
    public static TreeNode recoverTreeHelper(TreeNode root, TreeNode pre, List<TreeNode> res) {
        if(root == null) return null;
        TreeNode tmp;
        tmp = recoverTreeHelper(root.left, pre, res);
        pre = tmp != null? tmp : pre;
        if(pre != null) {
            System.out.println(pre.val + " vs " + root.val);
            if(pre.val > root.val) {
                if (res.size() == 0) {
                    res.add(pre);
                    res.add(root);
                }
                else{
                   res.set(1, root);
                }
            }
        }
        pre = root;
        tmp = recoverTreeHelper(root.right, pre, res);
        pre = tmp != null? tmp : pre;
        return pre;
    }
}