package question.question100_199;

/*
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 * For example:
 * Given the following binary tree,
 1            <---
 /   \
 2     3         <---
 \     \
 5     4       <---
 You should return [1, 3, 4].
 */
import help.TreeNode;
import java.util.ArrayList;
import java.util.List;

//做这种广度优先搜索用维护level 的方法真的是蛮快捷的。
public class Question199_own {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		aux(res, root, 0);
		return res;
	}

	private void aux(List<Integer> res, TreeNode node, int level) {
		if (node == null)
			return;
		if (level < res.size())
			res.set(level, node.val);
		else
			res.add(node.val);
		//加上这两个判断会使得耗时低一点
		if (node.left != null)
			aux(res, node.left, level + 1);
		if (node.right != null)
			aux(res, node.right, level + 1);
	}
}
