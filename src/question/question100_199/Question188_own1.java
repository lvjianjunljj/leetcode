package question.question100_199;

/*
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
import java.util.Arrays;

//根据123题的思路改写的，注意参数维护的顺序
//同时注意当k值比较大的时候就相当于不限制买入卖出次数了，就没必要用123的方法了，用122的方法就行
public class Question188_own1 {
	public int maxProfit(int k, int[] prices) {
		if (k == 0)
			return 0;
		if (k >= prices.length / 2) {
			int sum = 0;
			for (int i = 1; i < prices.length; i++)
				if (prices[i] > prices[i - 1])
					sum += prices[i] - prices[i - 1];
			return sum;
		}
		int[] b = new int[k];
		int[] s = new int[k];
		Arrays.fill(b, Integer.MIN_VALUE);
		for (int i : prices) {
			for (int j = k - 1; j > 0; j--) {
				s[j] = Math.max(s[j], b[j] + i);
				b[j] = Math.max(b[j], s[j - 1] - i);
			}
			s[0] = Math.max(s[0], b[0] + i);
			b[0] = Math.max(b[0], -i);
		}
		return s[k - 1];
	}
}
