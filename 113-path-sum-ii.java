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
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(root == null) {
			return res;
		}
		List<Integer> path = new ArrayList<Integer>();
		pathSumHelper(root, sum, 0, path, res);
		return res;
	}
	public void pathSumHelper(TreeNode root, int sum, int tmp, List<Integer> path, List<List<Integer>> res) {
		if(root == null) {
			return res;
		}
		path.add(root.val);
		tmp += root.val;
		if(root.left == null && root.right == null && tmp == sum) {
			res.add(path);
			return;
		}
		allPathSumHelper(root.left, sum, tmp, path, res);
		allPathSumHelper(root.right, sum, tmp, path, res);
	}
}