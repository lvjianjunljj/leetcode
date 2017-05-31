package question.question200_299;

import help.TreeNode;
import java.util.ArrayList;
import java.util.List;
//答案给的方法思路是一样的，做了些许的优化。
public class Question257_others {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new ArrayList<String>();
		helper(root, result, "");
		return result;
	}

	public void helper(TreeNode root, List<String> result, String path) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			result.add(path + root.val);
			return;
		}

		helper(root.left, result, path + root.val + "->");
		helper(root.right, result, path + root.val + "->");
		return;
	}
}
