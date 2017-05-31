package question.question100_199;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import help.TreeNode;

/*
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 3
 / \
 9  20
 /  \
 15   7
 return its bottom-up level order traversal as:
 [
 [15,7],
 [9,20],
 [3]
 ]
 */
//用Question102的方法先得到由根到叶，再倒置一下
public class Question107_others1 {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<List<Integer>> temp = new ArrayList<List<Integer>>();
		aux(root, 0, temp);
		for (int i = temp.size() - 1; i >= 0; i--)
			res.add(temp.get(i));
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
