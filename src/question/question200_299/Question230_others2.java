package question.question200_299;

import help.TreeNode;
//将count作为辅助方法的输入很难实现算法，所以只能作为全局变量一直在维护。
public class Question230_others2 {
	int res;
	int count;

	public int kthSmallest(TreeNode root, int k) {
		count = k;
		aux(root);
		return res;
	}

	private void aux(TreeNode node) {
		if (node.left != null)
			aux(node.left);
		count--;
		if (count == 0) {
			res = node.val;
			return;
		}
		if (node.right != null)
			aux(node.right);
	}
}
