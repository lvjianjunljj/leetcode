package question.question200_299;

/*
 * Invert a binary tree.
 4
 /   \
 2     7
 / \   / \
 1   3 6   9
 to
 4
 /   \
 7     2
 / \   / \
 9   6 3   1
 */
import help.TreeNode;
//用递归做很简单
public class Question226_own {
	public TreeNode invertTree(TreeNode root) {
		aux(root);
		return root;
	}

	private void aux(TreeNode node) {
		if (node == null)
			return;
		TreeNode temp = node.left;
		node.left = node.right;
		node.right = temp;
		aux(node.left);
		aux(node.right);
	}
}
