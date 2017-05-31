package question.question300_399;

import help.TreeNode;

//太奇怪了，同样都是用DFS，用数组去维护耗时就只是1ms，有点意思
//解释：我封装的DFS方法多传入一个boolean参数，所以每个点至少要遍历两次，号是自然就长了
public class Question337_others {
	public int rob(TreeNode root) {
		int[] res = aux(root);
		return Math.max(res[0], res[1]);
	}

	private int[] aux(TreeNode node) {
		int[] res = new int[2];
		if (node == null)
			return res;
		int[] left = aux(node.left);
		int[] right = aux(node.right);
		res[0] = node.val + left[1] + right[1];
		res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		return res;
	}
}
