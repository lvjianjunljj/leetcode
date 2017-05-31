package question.question1_99;
//动态规划才是出题者想要的方法，但是耗时确实还是要长一些，而且空间复杂度是m*n
public class Question62_own2 {
	public int uniquePaths(int m, int n) {
		int[][] res = new int[m + 1][n + 1];
		for (int i = 0; i < m + 1; i++)
			res[i][0] = 0;
		for (int i = 0; i < n + 1; i++)
			res[0][i] = 0;
		res[1][1] = 1;
		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (i > 1 || j > 1)
					res[i][j] = res[i - 1][j] + res[i][j - 1];
			}
		}
		return res[m][n];
	}
}
