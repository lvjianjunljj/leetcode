package question.question100_199;

import help.TreeNode;

public class Question110_own {
	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		return aux(root.left, root.right);
	}

	private boolean aux(TreeNode left, TreeNode right) {
		if (Math.abs(getDepth(left, 0) - getDepth(right, 0)) > 1)
			return false;
		else if (left == null || right == null)
			return true;
		else
			return aux(left.left, left.right) && aux(right.left, right.right);
	}

	private int getDepth(TreeNode node, int index) {
		if (node == null)
			return index;
		index++;
		return Math
				.max(getDepth(node.left, index), getDepth(node.right, index));
	}
}
