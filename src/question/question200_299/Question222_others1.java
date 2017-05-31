package question.question200_299;

import help.TreeNode;

//果然还是有非常简炼的想法和写法的
public class Question222_others1 {
	public int countNodes(TreeNode root) {
		int h = getHigh(root);
		return h == -1 ? 0 : (getHigh(root.right) == h - 1 ? (1 << h)
				+ countNodes(root.right) : (1 << (h - 1))
				+ countNodes(root.left));
	}

	private int getHigh(TreeNode node) {
		if (node == null)
			return -1;
		return getHigh(node.left) + 1;
	}
}
