package question.question100_199;

import java.util.Stack;
import help.TreeNode;
//用栈很好实现他们对于空间复杂度的要求，但是耗时确实高了一些（应该是测试时next方法多次调用导致耗时变长——虽然next方法的空间复杂度还是O1）
public class Question173_own2 {
	Stack<TreeNode> stack = new Stack<TreeNode>();

	public Question173_own2(TreeNode root) {
		add(root);
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode node = stack.pop();
		add(node.right);
		return node.val;
	}

	private void add(TreeNode node) {
		if (node == null)
			return;
		stack.add(node);
		add(node.left);
	}
}
