package question.question100_199;

/*
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * For example:
 * Given binary tree {1,#,2,3},
 1
 \
 2
 /
 3
 return [1,2,3].
 Note: Recursive solution is trivial, could you do it iteratively?
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import help.TreeNode;
//类比Question94，这里是前序遍历，思路都是一样的，就是在往List里添加值的时间不同——前序遍历和BFS不一样
//递归的方法就不写了，太简单了
public class Question144_own {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;
		while (node != null || !stack.isEmpty()) {
			while (node != null) {
				res.add(node.val);
				stack.add(node);
				node = node.left;
			}
			node = stack.pop().right;
		}
		return res;
	}
}
