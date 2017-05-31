package question.question100_199;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import help.TreeNode;
//检索的时候直接倒置，减少了空间复杂度，但是耗时好像增加了。
public class Question107_others2 {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
		aux(root, 0, res);
		return res;
	}

	private void aux(TreeNode node, int level, LinkedList<List<Integer>> res) {
		if (node == null)
			return;
		if (level == res.size())
			res.addFirst(new ArrayList<Integer>());
		res.get(res.size() - level - 1).add(node.val);
		level++;
		aux(node.left, level, res);
		aux(node.right, level, res);
	}
}
