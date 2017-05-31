package question.question500_599;

import java.util.*;

import help.TreeNode;

/**
 * @author lvjj
 * @date 2017年4月16日Given a binary tree, find the leftmost value in the last row
 *       of the tree.
 * 
 *       Example 1: Input:
 * 
 *       2 / \ 1 3
 * 
 *       Output: 1 Example 2: Input:
 * 
 *       1 / \ 2 3 / / \ 4 5 6 / 7
 * 
 *       Output: 7 Note: You may assume the tree (i.e., the given root node) is
 *       not NULL.
 */
public class Question513_own {
	// 参考501维护两个成员变量就出来了，思路很快，只是感觉有些抄袭501就mark一下
	int res = 0;
	int row = 0;

	public int findBottomLeftValue(TreeNode root) {
		dfs(root, 1);
		return res;
	}

	private void dfs(TreeNode node, int curRow) {
		if (node == null) {
			return;
		}
		dfs(node.left, curRow + 1);
		if (curRow > row) {
			row = curRow;
			res = node.val;
		}
		dfs(node.right, curRow + 1);
	}
}
