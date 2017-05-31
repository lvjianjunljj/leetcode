package question.question1_99;

/*
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * For example,
 * Consider the following matrix:
 [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 Given target = 3, return true.
 */
//二叉搜索，很快就出来了，没意思
public class Question74_own {
	public boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		int n = 0;
		if (m == 0)
			return false;
		n = matrix[0].length;
		if (n == 0)
			return false;
		int i = 0, j = m;
		while (i + 1 < j) {
			int k = (i + j) / 2;
			if (target > matrix[k][0])
				i = k;
			else if (target < matrix[k][0])
				j = k;
			else
				return true;
		}
		int mark = i;
		i = 0;
		j = n;
		while (i + 1 < j) {
			int k = (i + j) / 2;
			if (target > matrix[mark][k])
				i = k;
			else if (target < matrix[mark][k])
				j = k;
			else
				return true;
		}
		return target == matrix[mark][i];
	}
}
