package question.question1_99;

import help.TreeNode;
import java.util.ArrayList;
import java.util.List;

//这道题用类似于动态规划的方法也能做
public class Question95_others {
	public List<TreeNode> generateTrees(int n) {
		List<TreeNode>[] data = new ArrayList[n + 1];
		data[0] = new ArrayList<TreeNode>();
		data[0].add(null);
		for (int i = 1; i <= n; i++) {
			data[i] = new ArrayList<TreeNode>();
			for (int j = 0; j < i; j++) {
				for (TreeNode left : data[j]) {
					for (TreeNode right : data[i - 1 - j]) {
						TreeNode node = new TreeNode(j + 1);
						node.left = clone(left, 0);
						node.right = clone(right, j + 1);
						data[i].add(node);
					}
				}
			}
		}
		data[0] = new ArrayList<TreeNode>();
		return data[n];
	}

	private TreeNode clone(TreeNode node, int add) {
		if (node == null)
			return null;
		TreeNode res = new TreeNode(node.val + add);
		res.left = clone(node.left, add);
		res.right = clone(node.right, add);
		return res;
	}
}
