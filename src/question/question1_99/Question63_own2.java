package question.question1_99;

//精简一下代码
public class Question63_own2 {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		for (int i = 0; i < obstacleGrid.length; i++) {
			for (int j = 0; j < obstacleGrid[0].length; j++) {
				if (obstacleGrid[i][j] == 1) {
					obstacleGrid[i][j] = 0;
				} else {
					if (i == 0 && j == 0) {
						obstacleGrid[i][j] = 1;
					} else {
						obstacleGrid[i][j] = (i > 0 ? obstacleGrid[i - 1][j]
								: 0) + (j > 0 ? obstacleGrid[i][j - 1] : 0);
					}
				}
			}
		}
		return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
	}
}
