package question.question100_199;

import help.TreeNode;
import java.util.ArrayList;
import java.util.List;

//精简了算法，但是耗时变长了。。。
public class Question113_own2 {
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
		if (node.left == null && node.right == null)
			if (com == sum)
				res.add(new ArrayList<Integer>(element));
		if (node.left != null)
			dfs(res, new ArrayList<Integer>(element), node.left, com, sum);
		if (node.right != null)
			dfs(res, new ArrayList<Integer>(element), node.right, com, sum);
	}
}
