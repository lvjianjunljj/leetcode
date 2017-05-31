package question.question100_199;

/*
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 For example,

 1
 / \
 2   3
 The root-to-leaf path 1->2 represents the number 12.
 The root-to-leaf path 1->3 represents the number 13.
 Return the sum = 12 + 13 = 25.
 */
import help.TreeNode;
//用DFS还是非常简单的
public class Question129_own {
	public int sumNumbers(TreeNode root) {
		int[] res = new int[1];
		res[0] = 0;
		dfs(root, res, 0);
		return res[0];
	}

	private void dfs(TreeNode node, int[] res, int curNum) {
		if (node == null)
			return;
		curNum = curNum * 10 + node.val;
		if (node.left == null && node.right == null)
			res[0] += curNum;
		if (node.left != null)
			dfs(node.left, res, curNum);
		if (node.right != null)
			dfs(node.right, res, curNum);
	}
}
