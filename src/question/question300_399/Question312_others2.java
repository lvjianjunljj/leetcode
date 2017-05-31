package question.question300_399;
//在原有的基础上进行优化，减少了外部方法的调用和变量的赋值。
public class Question312_others2 {
	public int maxCoins(int[] nums) {
		int n = nums.length;
		if (n == 0)
			return 0;
		int[] newnums = new int[n + 2];
		int[][] res = new int[n + 2][n + 2];
		for (int i = 0; i < n; i++)
			newnums[i + 1] = nums[i];
		newnums[0] = newnums[n + 1] = 1;
		for (int len = 1; len <= n; len++) {
			for (int start = 0; start <= n - len; start++) {
				int end = start + len - 1;
				for (int i = start; i <= end; i++)
					res[start + 1][end + 1] = Math.max(res[start + 1][end + 1],
							newnums[start] * newnums[i + 1] * newnums[end + 2]
									+ res[start + 1][i] + res[i + 2][end + 1]);
			}
		}
		return res[1][n];
	}
}
