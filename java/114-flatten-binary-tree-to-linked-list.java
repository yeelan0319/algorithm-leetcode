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
	public void flatten(TreeNode root) {
		if(root == null) return;
		flattenHelper(root, null);	
	}
	public TreeNode flattenHelper(TreeNode root, TreeNode next) {
		if(root.right != null) {
			next = flattenHelper(root.right, next);
		}
		if(root.left != null) {
			next = flattenHelper(root.left, next);
		}
		root.right = next;
		root.left = null;
		return root;
	}
}