package question.question300_399;

//在others1的基础上进行修改，降低空间复杂度到O1，耗时也降低了
public class Question309_others2 {
	public int maxProfit(int[] prices) {
		int n = prices.length;
		if (n < 2)
			return 0;
		int s0 = 0, s1 = -prices[0], s2 = 0;
		for (int i = 0; i < n; i++) {
			int tmp0 = s0, tmp1 = s1, tmp2 = s2;
			s0 = Math.max(tmp0, tmp2);
			s1 = Math.max(tmp1, tmp0 - prices[i]);
			s2 = tmp1 + prices[i];
		}
		return Math.max(s0, s2);
	}
}
