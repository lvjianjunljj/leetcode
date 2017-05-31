package question.question300_399;

import java.util.TreeSet;

//用树的数据结构减少调一次循环，而且减少的耗时是max(m, n)，确实减少耗时
//注意在最内层循环最后加val，因为一旦数组不是null，就不能一个数不选返回0（题目要求）
public class Question363_others1 {
	public int maxSumSubmatrix(int[][] matrix, int k) {
		int row = matrix.length;
		if (row == 0)
			return 0;
		int col = matrix[0].length;
		int m = Math.min(row, col);
		int n = Math.max(row, col);
		int res = Integer.MIN_VALUE;
		for (int i = 0; i < m; i++) {
			int[] array = new int[n];
			for (int j = i; j >= 0; j--) {
				int val = 0;
				TreeSet<Integer> tree = new TreeSet<Integer>();
				tree.add(0);
				for (int s = 0; s < n; s++) {
					array[s] = array[s]
							+ (row < col ? matrix[j][s] : matrix[s][j]);
					val += array[s];
					Integer sub = tree.ceiling(val - k);
					if (sub != null)
						res = Math.max(res, val - sub);
					tree.add(val);
				}
			}
		}
		return res;
	}
}
