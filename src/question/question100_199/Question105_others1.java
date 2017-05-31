package question.question100_199;

import java.util.HashMap;
import help.TreeNode;

//用HashMap存储值与坐标的对应关系直接调取，确实可以降低耗时
public class Question105_others1 {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; i++)
			map.put(inorder[i], i);
		return aux(map, preorder, inorder, 0, preorder.length - 1, 0);
	}

	// 其实可以将代码再精简一下， inEnd这个参数其实并没有事吗用
	private TreeNode aux(HashMap<Integer, Integer> map, int[] preorder,
			int[] inorder, int preStart, int preEnd, int inStart) {
		if (preStart > preEnd)
			return null;
		TreeNode node = new TreeNode(preorder[preStart]);
		int index = map.get(preorder[preStart]) - inStart;
		node.left = aux(map, preorder, inorder, preStart + 1, preStart + index,
				inStart);
		node.right = aux(map, preorder, inorder, preStart + index + 1, preEnd,
				inStart + index + 1);
		return node;
	}
}
