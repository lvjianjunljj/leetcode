package question.question300_399;
//对代码的进一步优化，这次的耗时确实是低了很多。
public class Question312_others3 {
	public int maxCoins(int[] nums) {
		int n = nums.length;
		if (n == 0)
			return 0;
		int[] array = new int[n + 2];
		for (int i = 0; i < n; i++)
			array[i + 1] = nums[i];
		array[0] = array[n + 1] = 1;
		int[][] res = new int[n + 2][n + 2];
		for (int i = 1; i < n + 1; i++)
			for (int j = i; j >= 1; j--)
				for (int k = j; k <= i; k++)
					res[j][i] = Math.max(res[j][i], array[j - 1] * array[k]
							* array[i + 1] + res[j][k - 1] + res[k + 1][i]);
		return res[1][n];
	}
}
