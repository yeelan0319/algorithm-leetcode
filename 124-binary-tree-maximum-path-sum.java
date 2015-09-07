/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Result {
	int completePath;
	int partialPath;
	Result() {
		completePath = 0;
		partialPath = 0;
	}
}
public class Solution {
	public int maxPathSum(TreeNode root) {
		if(root == null) return 0;
		return maxPathSumHelper(root).completePath;
	}
	public result maxPathSumHelper(TreeNode root) {
		Result res = new Result();
		if(root == null) return res;
		Result leftres = maxPathSumHelper(root.left);
		Result rightres = maxPathSumHelper(root.right);
		int completePath = leftres.partialPath + rightres.partialPath + root.val;
		int submaxCompletePath = Math.max(leftres.completePath, rightres.completePath);
		res.partialPath = Math.max(leftres.partialPath, rightres.partialPath) + root.val;
		res.completePath = Math.max(completePath, submaxCompletePath);
		return res;
	}
}