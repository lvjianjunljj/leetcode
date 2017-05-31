package question.question1_99;

import help.TreeNode;

//用了他给的思路以后只要是能实现中序遍历的方法都是可以的——这里就用递归实现的
public class Question99_others2 {

	TreeNode prev = null, first = null, second = null;

	public void recoverTree(TreeNode root) {
		dfs(root);
		int val = first.val;
		first.val = second.val;
		second.val = val;
	}

	private void dfs(TreeNode node) {
		if (node == null)
			return;
		dfs(node.left);
		//主要实现就是这个思路
		if (prev != null && prev.val > node.val) {
			if (first == null)
				first = prev;
			second = node;
		}
		prev = node;
		dfs(node.right);
	}
}
