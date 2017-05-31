package question.question500_599;

import java.util.*;

import help.TreeNode;

/**
 * @author lvjj
 * @date 2017年4月16日Given a binary search tree (BST) with duplicates, find all
 *       the mode(s) (the most frequently occurred element) in the given BST.
 * 
 *       Assume a BST is defined as follows:
 * 
 *       The left subtree of a node contains only nodes with keys less than or
 *       equal to the node's key. The right subtree of a node contains only
 *       nodes with keys greater than or equal to the node's key. Both the left
 *       and right subtrees must also be binary search trees. For example: Given
 *       BST [1,null,2,2], 1 \ 2 / 2 return [2].
 * 
 *       Note: If a tree has more than one mode, you can return them in any
 *       order.
 * 
 *       Follow up: Could you do that without using any extra space? (Assume
 *       that the implicit stack space incurred due to recursion does not
 *       count).
 * 
 *       Subscribe to see which companies asked this question.
 */
public class Question501_others {
	//其实就是用中序遍历来做，别想太多了
	List<Integer> list = new ArrayList<Integer>();
	int max = 0;
	int count = 0;
	Integer value;

	public int[] findMode(TreeNode root) {
		aux(root);
		int[] res = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}
		return res;
	}

	private void aux(TreeNode node) {
		if (node == null) {
			return;
		}
		aux(node.left);
		if (value == null) {
			value = node.val;
			count = 1;
			max = 1;
		} else if (node.val == value) {
			count++;
		} else {
			count = 1;
			value = node.val;
		}
		if (max < count) {
			max = count;
			list.clear();
			list.add(value);
		} else if (count == max) {
			list.add(value);
		}
		aux(node.right);
	}
}
