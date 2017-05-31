package question.question100_199;

import java.util.HashMap;
import help.TreeNode;
//修改下getIndex的循环顺序耗时就可以大大降低，应该是 和leetcode本身的输入有关，一种投机的写法而已
public class Question105_others2 {
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
		for (int i = inEnd; i >= inStart; i--)
			if (inorder[i] == val)
				return i - inStart;
		return -1;
	}
}
