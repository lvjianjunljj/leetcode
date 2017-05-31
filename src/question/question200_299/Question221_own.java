package question.question200_299;

/*
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.
 * For example, given the following matrix:
 1 0 1 0 0
 1 0 1 1 1
 1 1 1 1 1
 1 0 0 1 0
 Return 4.
 */
//就是一个个遍历，耗时并不长
//但是用动态规划的方法，这应该才是出题的意图
public class Question221_own {
	public int maximalSquare(char[][] matrix) {
		int n = matrix.length;
		int m = 0;
		if (n > 0)
			m = matrix[0].length;
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
		int n = matrix.length;
		int m = 0;
		if (n > 0)
			m = matrix[0].length;
		int result = 0;
		int step = Math.min(n - i, m - j);
		int max = 0;
		for (int k = 0; k < step; k++) {
			if (matrix[k + i][k + j] == '1')
				max++;
			else
				break;
		}
		FLAG: for (int p = 0; p < max; p++) {
			for (int q = 0; q < p + 1; q++) {
				if (matrix[i + p][j + q] == '0' || matrix[i + q][j + p] == '0')
					break FLAG;
			}
			result++;
		}
		return result * result;
	}
}
