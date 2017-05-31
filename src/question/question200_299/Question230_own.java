package question.question200_299;

/*
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 */
import java.util.ArrayList;
import java.util.List;
import help.TreeNode;
//先序遍历将搜索树中的值从大到小存到数组中然后取出K大的数，时间空间复杂度都是On。
public class Question230_own {
	public int kthSmallest(TreeNode root, int k) {
		List<Integer> array = new ArrayList<Integer>();
		add(array, root);
		return array.get(k - 1);
	}

	private void add(List<Integer> array, TreeNode node) {
		if (node == null)
			return;
		add(array, node.left);
		array.add(node.val);
		add(array, node.right);
	}
}
