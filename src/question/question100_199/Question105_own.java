package question.question100_199;

/*
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 */
import help.TreeNode;
//思路理清了并不难做，这是给了前序遍历和中序遍历，中序遍历第一个数是父节点，
//然后在前序遍历中找到这个数，它前面的数是是左子树的全部，后面是右子树的全部，然后再往下找左右子节点的左子树和右子树
//主要把两个数组的坐标和前后边界分别维护好才行
public class Question105_own {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return aux(preorder, inorder, 0, preorder.length - 1, 0,
				preorder.length - 1);
	}

	private TreeNode aux(int[] preorder, int[] inorder, int preStart,
			int preEnd, int inStart, int inEnd) {
		if (preStart > preEnd || inStart > inEnd)
			return null;
		TreeNode node = new TreeNode(preorder[preStart]);
		int index = getIndex(inorder, preorder[preStart], inStart, inEnd);
		node.left = aux(preorder, inorder, preStart + 1, preStart + index,
				inStart, inStart + index - 1);
		node.right = aux(preorder, inorder, preStart + index + 1, preEnd,
				inStart + index + 1, inEnd);
		return node;
	}

	private int getIndex(int[] inorder, int val, int inStart, int inEnd) {
		for (int i = inStart; i <= inEnd; i++)
			if (inorder[i] == val)
				return i - inStart;
		return -1;
	}
}
