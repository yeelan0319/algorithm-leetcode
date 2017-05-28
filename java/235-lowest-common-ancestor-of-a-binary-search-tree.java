/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		while((root.val > p.val && root.val > q.val) || (root.val < p.val && root.val < q.val)) {
			if(root.val > p.val) {
				root = root.left;
			}
			else {
				root = root.right;
			}
		}	
		return root;
	}
}