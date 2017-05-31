package question.question100_199;

/*
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 3
 / \
 9  20
 /  \
 15   7
 return its level order traversal as:
 [
 [3],
 [9,20],
 [15,7]
 ]
 */
import java.util.ArrayList;
import java.util.List;
import help.TreeNode;

//用递归还是很好做的，但是耗时还是比较长。——这个想法完全可以用队列实现
public class Question102_own {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<TreeNode> element = new ArrayList<TreeNode>();
		if (root == null)
			return res;
		element.add(root);
		while (!element.isEmpty()) {
			List<Integer> array = new ArrayList<Integer>();
			for (TreeNode node : element)
				array.add(node.val);
			res.add(array);
			element = aux(element);
		}
		return res;
	}

	private List<TreeNode> aux(List<TreeNode> nodes) {
		List<TreeNode> res = new ArrayList<TreeNode>();
		for (TreeNode node : nodes) {
			if (node != null) {
				if (node.left != null)
					res.add(node.left);
				if (node.right != null)
					res.add(node.right);
			}
		}
		return res;
	}
}
