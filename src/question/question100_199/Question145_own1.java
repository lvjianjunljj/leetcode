package question.question100_199;

/*
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * For example:
 * Given binary tree {1,#,2,3},
 1
 \
 2
 /
 3
 return [3,2,1].
 Note: Recursive solution is trivial, could you do it iteratively?
 */
import java.util.ArrayList;
import java.util.List;

import help.TreeNode;

//后序遍历，我认怂，用94和144的思路我不会做，我只能用递归实现一把了
public class Question145_own1 {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		dfs(res, root);
		return res;
	}

	private void dfs(List<Integer> res, TreeNode node) {
		if (node == null)
			return;
		dfs(res, node.left);
		dfs(res, node.right);
		res.add(node.val);
	}
}
