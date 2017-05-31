package question.question300_399;
//用动态规划做的，这应该才是出题者想要的方法。
public class Question343_own2 {
	public int integerBreak(int n) {
		int res = 1;
		if (n < 3)
			return res;
		if (n == 3)
			return 2;
		int[] matrix = new int[n];
		return aux(matrix, n);
	}

	public static int aux(int[] matrix, int k) {
		if (k < 4)
			return k;
		if (matrix[k - 1] > 0)
			return matrix[k - 1];
		int max = 1;
		for (int i = 2; i < k / 2 + 1; i++)
			max = Math.max(max, aux(matrix, i) * aux(matrix, k - i));
		matrix[k - 1] = max;
		return matrix[k - 1];
	}
}
