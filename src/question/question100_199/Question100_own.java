package question.question100_199;

/*
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 */
import help.TreeNode;
//和101题很像，就是用递归去做就行。
public class Question100_own {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null || q == null)
			return p == null && q == null;
		if (p.val != q.val)
			return false;
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
}
