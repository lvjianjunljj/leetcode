package question.question1_99;
/*
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 */
//用贪心算法很快就能出来了
public class Question64 {
	public int minPathSum(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		if (m == 1 && n == 1) {
			return grid[0][0];
		}
		int[][] cost = new int[n + 1][m + 1];
		for (int i = 0; i < n + 1; i++) {
			cost[i][0] = 99999;
		}
		for (int i = 0; i < m + 1; i++) {
			cost[0][i] = 99999;
		}
		cost[1][0] = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				cost[i + 1][j + 1] = Math.min(cost[i][j + 1], cost[i + 1][j])
						+ grid[i][j];
			}
		}
		return cost[n][m];
	}
}
