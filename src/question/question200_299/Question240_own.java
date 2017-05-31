package question.question200_299;

/*
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted in ascending from left to right.
 Integers in each column are sorted in ascending from top to bottom.
 For example,

 Consider the following matrix:

 [
 [1,   4,  7, 11, 15],
 [2,   5,  8, 12, 19],
 [3,   6,  9, 16, 22],
 [10, 13, 14, 17, 24],
 [18, 21, 23, 26, 30]
 ]
 Given target = 5, return true.

 Given target = 20, return false.
 */
//遍历每一行，然后对每一行进行二分法查找。
public class Question240_own {
	public boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		int n = 0;
		if (m == 0)
			return false;
		n = matrix[0].length;
		if (n == 0)
			return false;
		for (int k = 0; k < m; k++) {
			int i = 0, j = n;
			while (i + 1 < j) {
				int q = (i + j) / 2;
				if (matrix[k][q] < target)
					i = q;
				else if (matrix[k][q] > target)
					j = q;
				else
					return true;
			}
			if (matrix[k][i] == target)
				return true;
		}
		return false;
	}
}
