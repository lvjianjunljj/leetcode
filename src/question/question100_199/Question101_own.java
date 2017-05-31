package question.question100_199;

/*
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 1
 / \
 2   2
 / \ / \
 3  4 4  3
 */
import help.TreeNode;
//其实并不是很难，把左右相等的关系找到就好。
public class Question101_own {
	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		TreeNode left = root.left;
		TreeNode right = root.right;
		return aux(left, right);

	}

	private boolean aux(TreeNode left, TreeNode right) {
		if (left == null || right == null)
			return left == null && right == null;
		if (left.val != right.val)
			return false;
		else
			return aux(left.left, right.right) && aux(left.right, right.left);
	}
}
