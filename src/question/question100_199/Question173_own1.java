package question.question100_199;
/*
 * mplement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 */
import java.util.LinkedList;
import java.util.Queue;
import help.TreeNode;
//就是前序遍历一遍一个二分查找树，我无耻地用On的时间复杂度快速的实现了，看了提示才想起来用Stack实现在Olgn的空间复杂度实现
public class Question173_own1 {
	Queue<TreeNode> queue = new LinkedList<TreeNode>();

	public Question173_own1(TreeNode root) {
		add(root);
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !queue.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		return queue.poll().val;
	}

	private void add(TreeNode node) {
		if (node == null)
			return;
		add(node.left);
		queue.add(node);
		add(node.right);
	}
}
