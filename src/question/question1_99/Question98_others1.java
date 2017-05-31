package question.question1_99;

import help.TreeNode;
//这才是最简洁的方法，没必要将左和右分成两个子方法，可以将其作为两个参数传入子方法中。
//输入long是为了防止输入节点的值为Integer.MAX_VALUE或者Integer.MIN_VALUE时出错
//当然像others2那样也行
public class Question98_others1 {
	public boolean isValidBST(TreeNode root) {
		return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	private boolean dfs(TreeNode node, long min, long max) {
		if (node == null)
			return true;
		if (node.val <= min || node.val >= max)
			return false;
		return dfs(node.left, min, node.val) && dfs(node.right, node.val, max);
	}
}
