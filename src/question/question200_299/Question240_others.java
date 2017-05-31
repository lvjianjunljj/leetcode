package question.question200_299;
//这个方法比较巧妙，我确实是想不到————就是从右上开始，这样与target进行比较或大或小都只有一个方向走
public class Question240_others {
	public boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length, n = matrix[0].length, i = 0, j = n - 1;
		while (i < m && j >= 0) {
			if (matrix[i][j] == target)
				return true;
			else if (matrix[i][j] < target)
				i++;
			else
				j--;
		}
		return false;
	}
}
