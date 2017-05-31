package question.question100_199;

/*
 * Given a binary tree
 struct TreeLinkNode {
 TreeLinkNode *left;
 TreeLinkNode *right;
 TreeLinkNode *next;
 }
 Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 Initially, all next pointers are set to NULL.
 Note:
 You may only use constant extra space.
 You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 For example,
 Given the following perfect binary tree,
 1
 /  \
 2    3
 / \  / \
 4  5  6  7
 After calling your function, the tree should look like:
 1 -> NULL
 /  \
 2 -> 3 -> NULL
 / \  / \
 4->5->6->7 -> NULL
 */
import java.util.LinkedList;
import java.util.Queue;
import help.TreeLinkNode;
//像这种广度优先搜素都可以用队列来实现，但是这道题让用O1的空间复杂度而且用队列耗时也较长
public class Question116_own1 {
	public void connect(TreeLinkNode root) {
		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		if (root == null)
			return;
		queue.add(root);
		while (queue.size() > 0) {
			int size = queue.size();
			while (size-- > 1) {
				TreeLinkNode node = queue.poll();
				node.next = queue.peek();
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
			TreeLinkNode node = queue.poll();
			node.next = null;
			if (node.left != null)
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);
		}
	}
}
