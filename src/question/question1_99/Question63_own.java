package question.question1_99;

/*
 * Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?、
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 For example,
 There is one obstacle in the middle of a 3x3 grid as illustrated below.
 [
 [0,0,0],
 [0,1,0],
 [0,0,0]
 ]
 The total number of unique paths is 2.
 */
//用动态规划一做就出来了
public class Question63_own {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		if (m == 0)
			return 0;
		int n = obstacleGrid[0].length;
		int[][] res = new int[m + 1][n + 1];
		for (int i = 0; i < m + 1; i++)
			res[i][0] = 0;
		for (int i = 0; i < n + 1; i++)
			res[0][i] = 0;
		res[1][1] = obstacleGrid[0][0] == 1 ? 0 : 1;
		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (i > 1 || j > 1) {
					if (obstacleGrid[i - 1][j - 1] == 1)
						res[i][j] = 0;
					else
						res[i][j] = res[i - 1][j] + res[i][j - 1];
				}
			}
		}
		return res[m][n];
	}
}
