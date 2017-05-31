package question.question100_199;

import java.util.HashMap;
import help.TreeNode;

//仿照Question105_others1用HashMap存储值与坐标的对应关系直接调取，确实可以降低耗时
public class Question106_others1 {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; i++)
			map.put(inorder[i], i);
		return aux(map, inorder, postorder, 0, inorder.length - 1, 0,
				postorder.length - 1);
	}

	// 其实可以将代码再精简一下， inEnd这个参数其实并没有事吗用
	private TreeNode aux(HashMap<Integer, Integer> map, int[] inorder,
			int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
		if (inStart > inEnd || postStart > postEnd)
			return null;
		TreeNode node = new TreeNode(postorder[postEnd]);
		int index = map.get(postorder[postEnd]) - inStart;
		node.left = aux(map, inorder, postorder, inStart, inStart + index - 1,
				postStart, postStart + index - 1);
		node.right = aux(map, inorder, postorder, inStart + index + 1, inEnd,
				postStart + index, postEnd - 1);
		return node;
	}
}
