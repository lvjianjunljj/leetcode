package question.question100_199;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import help.TreeNode;
//谁说用用94和144的思路做不出来，有了add(index, val)方法就能做，只不过要先检索右子节点再检索左子节点
public class Question145_own2 {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;
		while (node != null || !stack.isEmpty()) {
			while (node != null) {
				res.add(0, node.val);
				stack.add(node);
				node = node.right;
			}
			node = stack.pop().left;
		}
		return res;
	}
}
