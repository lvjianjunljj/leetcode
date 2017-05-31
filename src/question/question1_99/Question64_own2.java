package question.question1_99;

//精简一下代码且不需要消耗额外的空间
public class Question64_own2 {
	public int minPathSum(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (i == 0 && j == 0) {
					continue;
				}
				if (i == 0) {
					grid[i][j] += grid[i][j - 1];
				} else if (j == 0) {
					grid[i][j] += grid[i - 1][j];
				} else {
					grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
				}
			}
		}
		return grid[grid.length - 1][grid[0].length - 1];
	}
}
