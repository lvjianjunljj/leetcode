package question.question300_399;

/*
 * Given a non-empty 2D matrix matrix and an integer k, find the max sum of a rectangle in the matrix such that 
 * its sum is no larger than k.
 * Example:
 * Given matrix = [
 * [1,  0, 1],
 * [0, -2, 3]
 * ]
 * k = 2
 * The answer is 2. Because the sum of rectangle [[0, 1], [-2, 3]] is 2 and 2 is the max number no larger 
 * than k (k = 2).
 * Note:
 * The rectangle inside the matrix must have an area > 0.
 * What if the number of rows is much larger than the number of columns?
 */

//没想到暴力破解居然还能过，简直无聊——别的方法我也不会
public class Question363_own {
	public int maxSumSubmatrix(int[][] matrix, int k) {
		int m = matrix.length;
		if (m == 0)
			return 0;
		int n = matrix[0].length;
		int[][] sum = new int[m][n];
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++) {
				sum[i][j] = (i > 0 ? sum[i - 1][j] : 0)
						+ (j > 0 ? sum[i][j - 1] : 0)
						- (i > 0 && j > 0 ? sum[i - 1][j - 1] : 0)
						+ matrix[i][j];
				if (sum[i][j] == k || matrix[i][j] == k)
					return k;
			}
		int res = Integer.MIN_VALUE;
		for (int i = 0; i < m; i++)
			for (int x = 0; x <= i; x++)
				for (int j = 0; j < n; j++)
					for (int y = 0; y <= j; y++) {
						int tmp = sum[i][j] - (x > 0 ? sum[x - 1][j] : 0)
								- (y > 0 ? sum[i][y - 1] : 0)
								+ (x > 0 && y > 0 ? sum[x - 1][y - 1] : 0);
						if (tmp > res && tmp <= k)
							res = tmp;
					}
		return res;
	}
}
