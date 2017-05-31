package question.question1_99;
//空间复杂度O(n)，一个一个的赋值
public class Question48_O1 {
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n / 2; i++) {
			int tran = 0;
			for (int j = i; j < n - 1 - i; j++) {
				tran = matrix[i][j];
				matrix[i][j] = matrix[n - 1 - j][i];
				matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
				matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
				matrix[j][n - 1 - i] = tran;
			}

		}
	}
}
