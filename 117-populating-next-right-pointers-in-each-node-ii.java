/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
	public void connect(TreeLinkNode root) {
		if(root == null) return;
		LinkedList<TreeLinkNode> current = new LinkedList<TreeLinkNode>();
		LinkedList<TreeLinkNode> next = new LinkedList<TreeLinkNode>();
		next.add(root);
		while(next.size() > 0) {
			LinkedList<TreeLinkNode> tmp = current;
			current = next;
			next = tmp;
			while(current.size() > 0) {
				TreeLinkNode currentNode = current.removeFirst();
				TreeLinkNode nextNode = current.size() > 0 ? current.getFirst() : null;
				currentNode.next = nextNode;
				if(currentNode.left != null) {
					next.add(currentNode.left);
				}
				if(currentNode.right != null) {
					next.add(currentNode.right);
				}
			}
		}
	}
}