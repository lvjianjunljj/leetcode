package question.question300_399;
//利用二分查找去做——一定注意好边界条件的调整（以后二分查找第k个数都是这样子，l <= h都要继续向下走）
//查找的时候用到了240题的方法，从右上或者左下开始，还是非常快的
public class Question378_others2 {
	public int kthSmallest(int[][] matrix, int k) {
		int n = matrix.length;
		int l = matrix[0][0], h = matrix[n - 1][n - 1];
		while (l <= h) {
			int mid = h + (l - h) / 2;
			int count = getRanking(matrix, mid);
			if (count < k)
				l = mid + 1;
			else
				h = mid - 1;
		}
		return l;
	}

	private int getRanking(int[][] matrix, int val) {
		int n = matrix.length, res = 0, i = 0, j = n - 1;
		while (i < n && j > -1) {
			if (val >= matrix[i][j]) {
				i++;
				res += j + 1;
			} else
				j--;
		}
		return res;
	}
}
