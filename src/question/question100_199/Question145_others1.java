package question.question100_199;

import help.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
//要用到数组的add(index, val)方法，想到了但是没能实现——algorithm中有更美妙的方法
public class Question145_others1 {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.add(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			res.add(0, node.val);
			if (node.left != null)
				stack.add(node.left);
			if (node.right != null)
				stack.add(node.right);
		}
		return res;
	}
}
