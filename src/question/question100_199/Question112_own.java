package question.question100_199;

/*
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * For example:
 * Given the below binary tree and sum = 22,
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \      \
 7    2      1
 return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
import help.TreeNode;
//就是DFS，很简单
public class Question112_own {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (dfs(root, 0, sum))
			return true;
		return false;
	}

	private boolean dfs(TreeNode node, int curSum, int sum) {
		if (node == null)
			return false;
		curSum += node.val;
		if (node.left == null && node.right == null && curSum == sum)
			return true;
		if (node.left != null)
			if (dfs(node.left, curSum, sum))
				return true;
		if (node.right != null)
			if (dfs(node.right, curSum, sum))
				return true;
		return false;
	}
}
