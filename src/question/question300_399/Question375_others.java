package question.question300_399;
//别忘了还有这种自顶向下的动态规划，再不写就快忘了
public class Question375_others {
	public int getMoneyAmount(int n) {
		int[][] dp = new int[n][n];
		return aux(dp, 1, n);
	}

	private int aux(int[][] dp, int s, int e) {
		if (s >= e)
			return 0;
		if (dp[s - 1][e - 1] > 0)
			return dp[s - 1][e - 1];
		int res = Integer.MAX_VALUE;
		for (int i = s + 2; i < e; i++) {
			res = Math.min(res, Math.max(aux(dp, s, i - 1), aux(dp, i + 1, e))
					+ i);
		}
		dp[s - 1][e - 1] = s + 2 >= e ? e - 1 : res;
		return dp[s - 1][e - 1];
	}
}
