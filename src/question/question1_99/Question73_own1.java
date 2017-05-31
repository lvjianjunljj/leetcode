package question.question1_99;
/*
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 */
import java.util.HashSet;
//我已开始想到的就是用HashSet存储为零的点的row和column，但是没有要用HashSet存，直接用数组反而更快
public class Question73_own1 {
	public void setZeroes(int[][] matrix) {
		int m = matrix.length;
		if (m == 0)
			return;
		int n = matrix[0].length;
		HashSet<Integer> row = new HashSet<Integer>();
		HashSet<Integer> column = new HashSet<Integer>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					row.add(i);
					column.add(j);
				}
			}
		}
		for (int i : row)
			for (int j = 0; j < n; j++)
				matrix[i][j] = 0;
		for (int j : column)
			for (int i = 0; i < m; i++)
				matrix[i][j] = 0;
	}
}
