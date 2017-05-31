package question.question200_299;

/*
 * Given a binary tree, return all root-to-leaf paths.
 * For example, given the following binary tree:
 1
 /   \
 2     3
 \
 5
 All root-to-leaf paths are:
 ["1->2->5", "1->3"]
 */
import help.TreeNode;
import java.util.ArrayList;
import java.util.List;
//DFS都是用递归来实现的。以为用StringBuild替代String会降低耗时，想多了，耗时都不长。
public class Question257_own {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new ArrayList<String>();
		if (root != null)
			dfs(res, root, new StringBuilder());
		return res;
	}

	private void dfs(List<String> res, TreeNode node, StringBuilder sb) {
		if (node.left == null && node.right == null) {
			int tmp = sb.length();
			res.add(sb.append(node.val).toString());
			sb.delete(tmp, sb.length());
		}
		if (node.left != null) {
			int tmp = sb.length();
			dfs(res, node.left, sb.append(node.val).append("->"));
			sb.delete(tmp, sb.length());
		}
		if (node.right != null) {
			int tmp = sb.length();
			dfs(res, node.right, sb.append(node.val).append("->"));
			sb.delete(tmp, sb.length());
		}
	}
}
