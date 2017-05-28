import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yiranmao on 9/3/15.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }

    TreeNode(String[] arr) {
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        if(!arr[0].equals("#")){
            val = Integer.parseInt(arr[0]);
            q.add(this);
            for(int i = 1; i < arr.length; i = i + 2) {
                TreeNode cur = q.removeFirst();
                if(!arr[i].equals("#")){
                    cur.left = new TreeNode(Integer.parseInt(arr[i]));
                    q.add(cur.left);
                }
                if(i < arr.length - 1 && !arr[i + 1].equals("#")){
                    cur.right = new TreeNode(Integer.parseInt(arr[i + 1]));
                    q.add(cur.right);
                }
            }
        }
    }

    public String[] levelOrderSerialization(){
        if(this == null) return null;

        ArrayList<String> list = new ArrayList<String>();
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();

        q.add(this);
        list.add("" + this.val);
        while(q.size() > 0) {
            TreeNode cur = q.removeFirst();
            list.add(cur.left == null ? "#" : "" + cur.left.val);
            list.add(cur.right == null? "#" : "" + cur.right.val);
            if(cur.left != null) {
                q.add(cur.left);
            }
            if(cur.right != null){
                q.add(cur.right);
            }
        }
        while(list.get(list.size() - 1).equals("#")) list.remove(list.size() - 1);
        String[] res = new String[list.size()];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }

    public boolean equals(String[] otherSerialization){
        String[] thisSerialization = this.levelOrderSerialization();
        if(thisSerialization.length != otherSerialization.length){
            return false;
        }
        for(int i = 0; i < thisSerialization.length; i++){
            if(thisSerialization[i].equals(otherSerialization[i])) {
                return false;
            }
        }
        return true;
    }
}
