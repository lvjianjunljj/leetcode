package question.question100_199;

import help.TreeNode;
import java.util.ArrayList;
import java.util.List;

//这个优化过的算法通过维护一个level来降低了空间复杂度，同时降低了耗时。
public class Question102_others1 {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		aux(root, 0, res);
		return res;
	}

	private void aux(TreeNode node, int level, List<List<Integer>> res) {
		if (node == null)
			return;
		if (level == res.size())
			res.add(new ArrayList<Integer>());
		res.get(level++).add(node.val);
		aux(node.left, level, res);
		aux(node.right, level, res);
	}
}
