package question.question100_199;

import java.util.LinkedList;
import java.util.Queue;
import help.TreeNode;
//BFS都可以用队列来实现，但是这道题用队列太麻烦，没必要。
public class Question104_others1 {
	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		int depth = 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (queue.size() > 0) {
			int size = queue.size();
			while (size-- > 0) {
				TreeNode node = queue.poll();
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
			depth++;
		}
		return depth;
	}
}
