package question.question100_199;

import help.TreeLinkNode;

//在假设树为perfect tree 的前提下用递归来实现非常简单
public class Question116_own2 {
	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		aux(root.left, root.right);
	}

	private void aux(TreeLinkNode left, TreeLinkNode right) {
		if (left == null && right == null)
			return;
		else {
			left.next = right;
			right.next = null;
			aux(left.left, left.right);
			aux(left.right, right.left);
			aux(right.left, right.right);
		}
	}
}
