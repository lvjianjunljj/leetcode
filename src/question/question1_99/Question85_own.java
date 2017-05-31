package question.question1_99;
/*
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
 */
//我的方法是遍历真个数组，对为“1”的点进行aux计算，返回的是以这个点为左上角的最大面积的矩形的面积。
public class Question85_own {
	public int maximalRectangle(char[][] matrix) {
		int n = matrix.length;
		if (n <= 0) return 0;
		int m = matrix[0].length;
		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (matrix[i][j] == '1')
					result = Math.max(result, aux(matrix, i, j));
			}
		}
		return result;
	}

	public static int aux(char[][] matrix, int i, int j) {
		int minLen = 0;
		int len = Integer.MAX_VALUE;
		int n = matrix.length;
		int m = 0, max1 = 0, max2 = 0, result = 0;
		if (n > 0)
			m = matrix[0].length;
		for (int k = 0; k < n - i; k++) {
			if (matrix[k + i][j] == '1')
				max1++;
			else
				break;
		}
		for (int k = 0; k < m - j; k++) {
			if (matrix[i][k + j] == '1')
				max2++;
			else
				break;
		}
		for (int p = 0; p < max1; p++) {
			for (int q = 0; q < max2; q++) {
				minLen = q + 1;
				if (matrix[i + p][j + q] == '0') {
					minLen--;
					break;
				}
			}
			len = Math.min(len, minLen);
			result = Math.max(result, (p + 1) * len);
		}
		return result;
	}
}
