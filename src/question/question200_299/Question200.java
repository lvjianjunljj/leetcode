package question.question200_299;

public class Question200 {
	public static void main(String[] args) {
		
	}
	public int numIslands(char[][] grid) {
		int n = grid.length;
		if (n == 0) {
			return 0;
		}
		int m = grid[0].length;
		if (m == 0) {
			return 0;
		}
		int land = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == "1".charAt(0)) {
					surround(grid, i, j);
					land++;
				}
			}
		}
		return land;
	}

	public static void surround(char[][] grid, int i, int j) {
		if (i > -1 && j > -1 && i < grid.length && j < grid[0].length) {
			if (grid[i][j] == "1".charAt(0)) {
				grid[i][j] = 0;
				surround(grid, i - 1, j);
				surround(grid, i + 1, j);
				surround(grid, i, j + 1);
				surround(grid, i, j - 1);
			}
		}
	}
}
