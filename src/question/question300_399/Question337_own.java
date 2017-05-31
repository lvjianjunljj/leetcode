package question.question300_399;

/*
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 * Example 1:
 3
 / \
 2   3
 \   \ 
 3   1
 Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 Example 2:
 3
 / \
 4   5
 / \   \ 
 1   3   1
 Maximum amount of money the thief can rob = 4 + 5 = 9.
 */
import help.TreeNode;

//类比Question198和Question213
//我也是用DFS做啊，耗时居然1300ms。分分钟超时啊
public class Question337_own {
	public int rob(TreeNode root) {
		return aux(root, true);
	}

	private int aux(TreeNode node, boolean canRob) {
		if (node == null)
			return 0;
		if (canRob)
			return Math.max(node.val + aux(node.left, false)
					+ aux(node.right, false), aux(node.left, true)
					+ aux(node.right, true));
		else
			return aux(node.left, true) + aux(node.right, true);
	}
}
