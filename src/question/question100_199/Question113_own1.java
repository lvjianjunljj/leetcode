package question.question100_199;

/*
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * For example:
 * Given the below binary tree and sum = 22,
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \    / \
 7    2  5   1
 return
 [
 [5,4,11,2],
 [5,8,4,5]
 ]
 */
import help.TreeNode;
import java.util.ArrayList;
import java.util.List;
//用DFS做就行——注意别将数组加入结果中在对其进行操作。
public class Question113_own1 {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> element = new ArrayList<Integer>();
		if (root != null)
			dfs(res, element, root, 0, sum);
		return res;
	}

	private void dfs(List<List<Integer>> res, List<Integer> element,
			TreeNode node, int com, int sum) {
		element.add(node.val);
		com += node.val;
		int size = element.size();
		if (node.left == null && node.right == null) {
			if (com == sum) {
				res.add(new ArrayList<Integer>(element));
			}
		}
		if (node.left != null) {
			dfs(res, element, node.left, com, sum);
			for (; size < element.size();)
				element.remove(element.size() - 1);
		}
		if (node.right != null) {
			dfs(res, element, node.right, com, sum);
			for (; size < element.size();)
				element.remove(element.size() - 1);
		}

	}
}
