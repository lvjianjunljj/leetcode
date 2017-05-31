package question.question100_199;

import help.TreeNode;
//用这种递归简洁且耗时较低
public class Question104_others2 {
	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		int l = maxDepth(root.left);
		int r = maxDepth(root.right);
		return Math.max(l, r) + 1;
	}
}
