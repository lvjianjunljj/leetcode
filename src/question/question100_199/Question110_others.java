package question.question100_199;

import help.TreeNode;
//可以在求depth的过程中维护isBalanced属性，简洁且耗时比较低，其实用我自己封装的求depth的方法也能实现
public class Question110_others {
	boolean isBal = true;

	public boolean isBalanced(TreeNode root) {
		getDepth(root);
		return isBal;
	}

	private int getDepth(TreeNode node) {
		if (node == null)
			return 0;
		int l = getDepth(node.left);
		int r = getDepth(node.right);
		if (Math.abs(l - r) > 1)
			isBal = false;
		return Math.max(l, r) + 1;
	}
}
