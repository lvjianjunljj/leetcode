package question.question400_499;

/*
 * Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, 
 * the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right 
 * and bottom edges.
 * Water can only flow in four directions (up, down, left, or right) from a cell to another one 
 * with height equal or lower.
 * Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
 * Note:
 * The order of returned grid coordinates does not matter.
 * Both m and n are less than 150.
 * Example:
 * Given the following 5x5 matrix:
 Pacific ~   ~   ~   ~   ~ 
 ~  1   2   2   3  (5) *
 ~  3   2   3  (4) (4) *
 ~  2   4  (5)  3   1  *
 ~ (6) (7)  1   4   5  *
 ~ (5)  1   1   2   4  *
 *   *   *   *   * Atlantic
 Return:
 [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
 */
import java.util.ArrayList;
import java.util.List;

//果然对每一个点都进行dfs会超时，不行啊，要换个想法才行
public class Question417_own {
	public List<int[]> pacificAtlantic(int[][] matrix) {
		List<int[]> res = new ArrayList<int[]>();
		int m = matrix.length;
		if (m == 0) {
			return res;
		}
		int n = matrix[0].length;
		int[][] mat = new int[m + 2][n + 2];
		boolean[][] visit = new boolean[m + 2][n + 2];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				mat[i + 1][j + 1] = matrix[i][j];
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				boolean[] flow = new boolean[2];
				search(flow, mat, visit, i + 1, j + 1);
				if (flow[0] && flow[1]) {
					res.add(new int[] { i, j });
				}
			}
		}
		return res;
	}

	private void search(boolean[] flow, int[][] mat, boolean[][] visit, int i,
			int j) {
		if (i == 0 || j == 0) {
			flow[0] = true;
		} else if (i == mat.length - 1 || j == mat[0].length - 1) {
			flow[1] = true;
		} else {
			visit[i][j] = true;
			if (!visit[i - 1][j] && mat[i][j] >= mat[i - 1][j]) {
				visit[i - 1][j] = true;
				search(flow, mat, visit, i - 1, j);
				visit[i - 1][j] = false;
			}
			if (!visit[i + 1][j] && mat[i][j] >= mat[i + 1][j]) {
				visit[i + 1][j] = true;
				search(flow, mat, visit, i + 1, j);
				visit[i + 1][j] = false;
			}
			if (!visit[i][j - 1] && mat[i][j] >= mat[i][j - 1]) {
				visit[i][j - 1] = true;
				search(flow, mat, visit, i, j - 1);
				visit[i][j - 1] = false;
			}
			if (!visit[i][j + 1] && mat[i][j] >= mat[i][j + 1]) {
				visit[i][j + 1] = true;
				search(flow, mat, visit, i, j + 1);
				visit[i][j + 1] = false;
			}
			visit[i][j] = false;
		}
	}
}
