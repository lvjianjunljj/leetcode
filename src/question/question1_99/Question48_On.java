package question.question1_99;
/*
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 */
//空间复杂度O(n)，一行一行的赋值
public class Question48_On {
	public static void rotate(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n / 2; i++) {
			int[] tran = new int[n - 1 - 2 * i];
			for (int j = i; j < n - 1 - i; j++) {
				tran[j - i] = matrix[i][j];
			}
			for (int j = i; j < n - 1 - i; j++) {
				matrix[i][j] = matrix[n - 1 - j][i];
			}
			for (int j = i; j < n - 1 - i; j++) {
				matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
			}
			for (int j = i; j < n - 1 - i; j++) {
				matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
			}
			for (int j = i; j < n - 1 - i; j++) {
				matrix[j][n - 1 - i] = tran[j - i];
			}
		}
	}
}
