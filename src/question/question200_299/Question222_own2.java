package question.question200_299;

import help.TreeNode;

//这种二分查找每次递归都要调用两个计算当前点高度的方法，耗时还算比较低——但是写起来太麻烦了
public class Question222_own2 {

	int depth = 1, count = 0, leftHigh = 0, rightHigh = 0;

	public int countNodes(TreeNode root) {
		leftHigh = leftHigh(root);
		rightHigh = rightHigh(root);
		search(root);
		return count;
	}

	private void search(TreeNode node) {
		if (node == null)
			return;
		int left = rightHigh(node.left);
		if (left >= (leftHigh - depth)) {
			count += Math.max(1 << (leftHigh - (depth++)), 1);
			search(node.right);
		} else {
			count += Math.max(1 << (rightHigh - (depth++)), 1);
			search(node.left);
		}
	}
	
	private int rightHigh(TreeNode node) {
		if (node == null)
			return 0;
		return rightHigh(node.right) + 1;
	}

	private int leftHigh(TreeNode node) {
		if (node == null)
			return 0;
		return leftHigh(node.left) + 1;
	}
}
