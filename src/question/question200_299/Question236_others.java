package question.question200_299;

import help.TreeNode;

//这个递归用的太神了（在递归的过程中直接就搜索了p和q并通过判断返回其公共子节点）
//判断一个树中有没有某点用这个思路也是可以的
public class Question236_others {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q)
			return root;
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (left != null && right != null)
			return root;
		return left != null ? left : right;
	}
}a
