package question.question100_199;

/*
 * Given a binary tree, find the maximum path sum.
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path does not need to go through the root.
 * For example:
 * Given the below binary tree,
 1
 / \
 2   3
 Return 6.
 */
import help.TreeNode;
//一开始的DFS的思路是没有问题的，只要转变一下return的值（不是直接返回结果值而是左右较大的一个）就出正确答案了
public class Question124_others {
	int res = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		dfs(root);
		return res;
	}

	private int dfs(TreeNode node) {
		if (node == null)
			return 0;
		int left = Math.max(dfs(node.left), 0);
		int right = Math.max(dfs(node.right), 0);
		res = Math.max(res, node.val + left + right);
		return node.val + Math.max(left, right);
	}
}
