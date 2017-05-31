package question.question200_299;

import help.TreeNode;
//以为这样计算每一棵子树的方法时间复杂度高，耗时长呢，进过反而耗时低了，同时空间复杂度也变成了O1.
public class Question230_others1 {
	public int kthSmallest(TreeNode root, int k) {
		if (root == null)
			return 0;
		if (countNodes(root.left) == k - 1)
			return root.val;
		else if (countNodes(root.left) > k - 1)
			return kthSmallest(root.left, k);
		else
			return kthSmallest(root.right, k - countNodes(root.left) - 1);
	}

	public int countNodes(TreeNode node) {
		if (node == null)
			return 0;
		return countNodes(node.left) + countNodes(node.right) + 1;
	}
}
