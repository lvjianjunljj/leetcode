package question.question200_299;

//用动态规划做这道题才是正解，新的数组维护的是以其为右下角的最大正方形的边长
public class Question221_others {
	public int maximalSquare(char[][] matrix) {
		int m = matrix.length;
		if (m <= 0)
			return 0;
		int n = matrix[0].length;
		int max = 0;
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++)
			dp[i][0] = matrix[i][0] - '0';
		for (int i = 0; i < n; i++)
			dp[0][i] = matrix[0][i] - '0';
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == '0')
					dp[i][j] = 0;
				else {
					int l1 = dp[i - 1][j];
					int l2 = dp[i][j - 1];
					if (l1 != l2)
						dp[i][j] = Math.min(l1, l2) + 1;
					else {
						dp[i][j] = matrix[i - l1][j - l1] == '1' ? l1 + 1 : l1;
					}
				}
			}
		}
		for (int[] row : dp)
			for (int col : row)
				max = Math.max(max, col);
		return max * max;
	}
}
