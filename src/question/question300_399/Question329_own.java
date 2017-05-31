package question.question300_399;

/*
 * Given an integer matrix, find the length of the longest increasing path.
 * From each cell, you can either move to four directions: left, right, up or down. 
 * You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
 * Example 1:
 * nums = [
 * [9,9,4],
 * [6,6,8],
 * [2,1,1]
 * ]
 * Return 4
 * The longest increasing path is [1, 2, 6, 9].
 */

//我这道题其实是用动态规划做的维护一个数组表示以其为终点的最长path的长度，用回溯做肯定超时
//答案全是这个思路，没什么好想了
public class Question329_own {
	public int longestIncreasingPath(int[][] matrix) {
		int res = 0;
		int m = matrix.length;
		if (m == 0)
			return res;
		int n = matrix[0].length;
		int[][] length = new int[m][n];
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				res = Math.max(res, dfs(matrix, length, i, j, m, n));
		return res;
	}

	private int dfs(int[][] matrix, int[][] length, int i, int j, int m, int n) {
		if (length[i][j] > 0)
			return length[i][j];
		int res = 1;
		if (i > 0 && matrix[i][j] > matrix[i - 1][j]) {
			if (length[i - 1][j] > 0)
				res = Math.max(res, length[i - 1][j] + 1);
			else
				res = Math.max(res, dfs(matrix, length, i - 1, j, m, n) + 1);
		}
		if (j > 0 && matrix[i][j] > matrix[i][j - 1]) {
			if (length[i][j - 1] > 0)
				res = Math.max(res, length[i][j - 1] + 1);
			else
				res = Math.max(res, dfs(matrix, length, i, j - 1, m, n) + 1);
		}
		if (i + 1 < m && matrix[i][j] > matrix[i + 1][j]) {
			if (length[i + 1][j] > 0)
				res = Math.max(res, length[i + 1][j] + 1);
			else
				res = Math.max(res, dfs(matrix, length, i + 1, j, m, n) + 1);
		}
		if (j + 1 < n && matrix[i][j] > matrix[i][j + 1]) {
			if (length[i][j + 1] > 0)
				res = Math.max(res, length[i][j + 1] + 1);
			else
				res = Math.max(res, dfs(matrix, length, i, j + 1, m, n) + 1);
		}
		length[i][j] = res;
		return res;
	}
}
