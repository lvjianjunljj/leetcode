package question.question500_599;

import help.TreeNode;

/**
 * @author lvjj
 * @date 2017年4月22日 Given a Binary Search Tree (BST), convert it to a Greater
 *       Tree such that every key of the original BST is changed to the original
 *       key plus sum of all keys greater than the original key in BST.
 * 
 *       Example:
 * 
 *       Input: The root of a Binary Search Tree like this: 5 / \ 2 13
 * 
 *       Output: The root of a Greater Tree like this: 18 / \ 20 13
 */
public class Question538_others {
	//如果转成list可以On做出来，那一定要想到用终须遍历等方法
	int sum = 0;

	public TreeNode convertBST(TreeNode root) {
		aux(root);
		return root;
	}

	private void aux(TreeNode node) {
		if (node == null) {
			return;
		}
		aux(node.right);
		sum += node.val;
		node.val = sum;
		aux(node.left);
	}
}
