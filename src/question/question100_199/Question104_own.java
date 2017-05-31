package question.question100_199;

/*
 * Given a binary tree, find its maximum depth.
 *  The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
import help.TreeNode;
//通过index维护depth值，当碰到null时进行比较——用这种方式做BFS的题还是有一定的优势的
public class Question104_own {
	int depth = 0;

	public int maxDepth(TreeNode root) {
		getDepth(root, 0);
		return depth;
	}

	private void getDepth(TreeNode node, int index) {
		if (node == null)
			depth = Math.max(depth, index);
		else {
			index++;
			getDepth(node.left, index);
			getDepth(node.right, index);
		}
	}
}
