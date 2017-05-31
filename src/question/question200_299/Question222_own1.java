package question.question200_299;

/*
 * Given a complete binary tree, count the number of nodes.
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, 
 * is completely filled, and all nodes in the last level are as far left as possible. 
 * It can have between 1 and 2h nodes inclusive at the last level h.
 */
import help.TreeNode;

//遍历树中的每个node果然超时，而且没有用到complete binary tree的特性——
//一棵二叉树至多只有最下面的一层上的结点的度数可以小于2，
//并且最下层上的结点都集中在该层最左边的若干位置上，则此二叉树成为完全二叉树。
public class Question222_own1 {
	int count = 0;

	public int countNodes(TreeNode root) {
		bfs(root);
		return count;
	}

	private void bfs(TreeNode node) {
		if (node == null)
			return;
		count++;
		bfs(node.left);
		bfs(node.right);
	}
}
