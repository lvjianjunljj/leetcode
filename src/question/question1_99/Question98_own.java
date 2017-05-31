package question.question1_99;

/*
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * Example 1:
 2
 / \
 1   3
 Binary tree [2,1,3], return true.
 Example 2:
 1
 / \
 2   3
 Binary tree [1,2,3], return false.
 只能是大于和小于，等于也要返回false
 */
import help.TreeNode;

//调用本身判断左右节点的值是否符合，同时再调用封装的两个方法判断左右子树的值是否符合，但是这样重复步骤太多了，耗时偏长
public class Question98_own {
	public boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;
		if ((root.left != null && root.left.val >= root.val)
				|| (root.right != null && root.right.val <= root.val))
			return false;
		return isValidBST(root.left) && isValidBST(root.right)
				&& dfsLeft(root.left, root.val)
				&& dfsRight(root.right, root.val);
	}

	private boolean dfsLeft(TreeNode node, int max) {
		if (node == null)
			return true;
		if (node.val >= max)
			return false;
		return dfsLeft(node.left, max) && dfsLeft(node.right, max);
	}

	private boolean dfsRight(TreeNode node, int min) {
		if (node == null)
			return true;
		if (node.val <= min)
			return false;
		return dfsRight(node.left, min) && dfsRight(node.right, min);
	}
}
