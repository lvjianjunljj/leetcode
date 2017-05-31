package question.question1_99;

/*
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 * Note:
 * A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 */
import help.TreeNode;

//用莫里斯实现一个中序遍历就能找到这两个点，其实并不难
//这道题在空间复杂度为O1的前提下貌似只能用莫里斯遍历做——网上说用递归过程中也要占用空间，所以空间复杂度不是O1，我这么不信呢
public class Question99_others1 {
	public void recoverTree(TreeNode root) {
		TreeNode prev = null, first = null, second = null;
		while (root != null) {
			if (root.left == null) {
				//将输出变成这一段就行——第一个错序取前面的数，第二个错序取后面的数
				if (prev != null && prev.val > root.val) {
					if (first == null)
						first = prev;
					second = root;
				}
				prev = root;
				root = root.right;
			} else {
				TreeNode bef = root.left;
				while (bef.right != null && bef.right != root)
					bef = bef.right;
				if (bef.right == null) {
					bef.right = root;
					root = root.left;
				} else {
					if (prev != null && prev.val > root.val) {
						if (first == null)
							first = prev;
						second = root;
					}
					prev = root;
					bef.right = null;
					root = root.right;
				}
			}
		}
		int val = first.val;
		first.val = second.val;
		second.val = val;
	}
}
