package question.question1_99;

/*
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * For example:
 * Given binary tree [1,null,2,3],
 1
 \
 2
 /
 3
 return [1,3,2].
 Note: Recursive solution is trivial, could you do it iteratively?
 */
import java.util.ArrayList;
import java.util.List;
import help.TreeNode;

//这个题要的是中序遍历
//人家都说了，用递归做是非常不足为道的，要用迭代
public class Question94_own {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		bfs(res, root);
		return res;
	}

	private void bfs(List<Integer> res, TreeNode node) {
		if (node == null)
			return;
		bfs(res, node.left);
		res.add(node.val);
		bfs(res, node.right);
	}
}
