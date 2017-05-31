package question.question100_199;

import help.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
//用LinkedList实现，思路和others1是一样的
public class Question145_others2 {
	public List<Integer> postorderTraversal(TreeNode root) {
		LinkedList<Integer> res = new LinkedList<Integer>();
		if (root == null)
			return res;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.add(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			res.addFirst(node.val);
			if (node.left != null)
				stack.add(node.left);
			if (node.right != null)
				stack.add(node.right);
		}
		return res;
	}
}
