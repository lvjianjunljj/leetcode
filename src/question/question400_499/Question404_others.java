package question.question400_499;

import help.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

//用BFS或者DFS都是可以的，所以这里的数据类型用Queue或者Stack都行，只要遍历一遍所有的节点就行——太简单了，没什么好说的了
public class Question404_others {
	public int sumOfLeftLeaves(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int res = 0;
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			if (cur == null)
				continue;
			if (cur.left != null && cur.left.left == null
					&& cur.left.right == null)
				res += cur.left.val;
			queue.offer(cur.left);
			queue.offer(cur.right);
		}
		return res;
	}
}
