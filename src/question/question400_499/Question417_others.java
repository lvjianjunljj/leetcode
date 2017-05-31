package question.question400_499;

import java.util.ArrayList;
import java.util.List;

//这个想法确实巧妙，从四边分别寻找能到pacific和atlantic的点，然后遍历所有的点看哪个能都到达
public class Question417_others {
	public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<int[]>();
        int m = matrix.length;
        if (m == 0) {
            return res;
        }
        int n = matrix[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(matrix, pacific, i, 0, Integer.MIN_VALUE);
            dfs(matrix, atlantic, i, n - 1, Integer.MIN_VALUE);
        }
        for (int i = 0; i < n; i++) {
            dfs(matrix, pacific, 0, i, Integer.MIN_VALUE);
            dfs(matrix, atlantic, m - 1, i, Integer.MIN_VALUE);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(new int[]{ i, j });
                }
            }
        }
        return res;
    }
    private void dfs(int[][] matrix, boolean[][] visit, int i, int j, int high) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || visit[i][j] || matrix[i][j] < high) {
            return;
        }
        visit[i][j] = true;
        dfs(matrix, visit, i + 1, j, matrix[i][j]);
        dfs(matrix, visit, i - 1, j, matrix[i][j]);
        dfs(matrix, visit, i, j + 1, matrix[i][j]);
		dfs(matrix, visit, i, j - 1, matrix[i][j]);
	}
}
