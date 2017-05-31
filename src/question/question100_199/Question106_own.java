package question.question100_199;

/*
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 */
import help.TreeNode;
//和105类似，给的是中序遍历和后序遍历，思路是一样的，只不过是要从后序遍历的数组的最后一位开始向父节点添加
public class Question106_own {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return aux(inorder, postorder, 0, inorder.length - 1, 0,
				postorder.length - 1);
	}

	private TreeNode aux(int[] inorder, int[] postorder, int inStart,
			int inEnd, int postStart, int postEnd) {
		if (inStart > inEnd || postStart > postEnd)
			return null;
		TreeNode node = new TreeNode(postorder[postEnd]);
		int index = getIndex(inorder, postorder[postEnd], inStart, inEnd);
		node.left = aux(inorder, postorder, inStart, inStart + index - 1,
				postStart, postStart + index - 1);
		node.right = aux(inorder, postorder, inStart + index + 1, inEnd,
				postStart + index, postEnd - 1);
		return node;
	}

	private int getIndex(int[] inorder, int val, int inStart, int inEnd) {
		for (int i = inStart; i <= inEnd; i++)
			if (inorder[i] == val)
				return i - inStart;
		return -1;
	}
}
