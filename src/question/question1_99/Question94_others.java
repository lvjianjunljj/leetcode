package question.question1_99;

import help.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
//中序遍历的迭代实现，受教了。
public class Question94_others {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;
		while (node != null || !stack.isEmpty()) {
			while (node != null) {
				stack.add(node);
				node = node.left;
			}
			node = stack.pop();
			res.add(node.val);
			node = node.right;
		}
		return res;
	}
}
