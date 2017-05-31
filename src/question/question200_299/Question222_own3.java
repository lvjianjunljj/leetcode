package question.question200_299;

import help.TreeNode;

//用迭代代替others1中的递归，耗时确实降低了——大部分的答案的想法都是一样的，只是写法各有不同
public class Question222_own3 {
	public int countNodes(TreeNode root) {
		if (root == null)
			return 0;
		int h = -1, hRight = -1;
		TreeNode cur = root, curRight = cur.right;
		while (cur != null) {
			h++;
			cur = cur.left;
		}
		while (curRight != null) {
			hRight++;
			curRight = curRight.left;
		}
		return hRight == h - 1 ? (1 << h) + countNodes(root.right)
				: (1 << (h - 1)) + countNodes(root.left);
	}
}
