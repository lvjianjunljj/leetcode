package question.question1_99;
//用数组存储为零的点的row和column读取的时候要快一些，耗时短一点
public class Question73_own2 {
	public void setZeroes(int[][] matrix) {
		int m = matrix.length;
		if (m == 0)
			return;
		int n = matrix[0].length;
		boolean[] row = new boolean[m];
		boolean[] column = new boolean[n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					row[i] = true;
					column[j] = true;
				}
			}
		}
		for (int i = 0; i < m; i++)
			if (row[i])
				for (int j = 0; j < n; j++)
					matrix[i][j] = 0;
		for (int j = 0; j < n; j++)
			if (column[j])
				for (int i = 0; i < m; i++)
					matrix[i][j] = 0;
	}
}
