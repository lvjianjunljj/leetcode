package question.question100_199;

import help.TreeNode;

public class Question129_others1 {
	public int sumNumbers(TreeNode root) {
		return sum(root, 0);
	}

	private int sum(TreeNode node, int sum) {
		if (node == null)
			return 0;
		if (node.left == null && node.right == null)
			return sum * 10 + node.val;
		return sum(node.left, sum * 10 + node.val)
				+ sum(node.right, sum * 10 + node.val);
	}
}
