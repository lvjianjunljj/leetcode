package question.question100_199;

/*
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
//这个方法简直是太美妙了，这是我见过的最简洁的动态规划解法了，简直是爆炸——注意循环过程中对四个参数的维护顺序
public class Question123_others1 {
	public int maxProfit(int[] prices) {
		int s0 = 0, s1 = 0, b0 = Integer.MIN_VALUE, b1 = Integer.MIN_VALUE;
		for (int i : prices) {
			s1 = Math.max(s1, b1 + i);
			b1 = Math.max(b1, s0 - i);
			s0 = Math.max(s0, b0 + i);
			b0 = Math.max(b0, -i);
		}
		return s1;
	}
}
