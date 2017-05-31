package question.question300_399;

//最快的答案了——b0b1s0s1s2分别代表b[i]、b[i - 1]、s[i]、s[i - 1]、s[i - 2]确实比较巧妙
//s0 = Math.max(s1, b1 + prices[i]);的赋值也可以是s0 = Math.max(s1, b0 + prices[i]);没影响，仔细一想就知道了
public class Question309_others3 {
	public int maxProfit(int[] prices) {
		int n = prices.length;
		if (n < 2)
			return 0;
		int b0 = -prices[0], b1 = b0, s0 = 0, s1 = 0, s2 = 0;
		for (int i = 1; i < n; i++) {
			b0 = Math.max(b1, s2 - prices[i]);
			s0 = Math.max(s1, b1 + prices[i]);
			b1 = b0;
			s2 = s1;
			s1 = s0;
		}
		return s0;
	}
}
