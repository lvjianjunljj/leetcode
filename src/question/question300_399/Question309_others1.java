package question.question300_399;

//不是只维护两个一维数组就能解决的，有三种状态，所以要维护三个一维数组才能解决
//你要画出s0s1s2的状态图才能写出这种解法，简直是巧妙
//状态图请看https://discuss.leetcode.com/topic/30680/share-my-dp-solution-by-state-machine-thinking
public class Question309_others1 {
	public int maxProfit(int[] prices) {
		int n = prices.length;
		if (n < 2)
			return 0;
		int[][] dp = new int[n][3];
		dp[0][1] = -prices[0];
		for (int i = 1; i < n; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
			dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
			dp[i][2] = dp[i - 1][1] + prices[i];
		}
		return Math.max(dp[n - 1][0], dp[n - 1][2]);
	}
}
