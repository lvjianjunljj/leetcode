package question.question400_499;

/*
 * Find the sum of all left leaves in a given binary tree.
 * Example:
 3
 / \
 9  20
 /  \
 15   7
 There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */
import help.TreeNode;

//树的题很多都是用递归去做，这道题分两种请款来写其实很简单
public class Question404_own {
	public int sumOfLeftLeaves(TreeNode root) {
		return rightSum(root);
	}

	private int leftSum(TreeNode node) {
		if (node == null)
			return 0;
		if (node.left == null && node.right == null)
			return node.val;
		return leftSum(node.left) + rightSum(node.right);
	}

	private int rightSum(TreeNode node) {
		if (node == null || (node.left == null && node.right == null))
			return 0;
		return leftSum(node.left) + rightSum(node.right);
	}
}
