package question.question100_199;

import java.util.HashMap;
import help.TreeNode;
//和Question105_others2一样，没什么意思
public class Question106_others2 {
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
		for (int i = inEnd; i >= inStart; i--)
            if (inorder[i] == val)
                return i - inStart;
        return -1;
	}
}
