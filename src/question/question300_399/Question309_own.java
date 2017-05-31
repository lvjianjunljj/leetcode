package question.question300_399;

/*
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
 * (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 * Example:
 * prices = [1, 2, 3, 0, 2]
 * maxProfit = 3
 * transactions = [buy, sell, cooldown, buy, sell]
 */

//这动态规划做的我简直是想死，每次求res[i]都要遍历之前所有，不是个好方法
public class Question309_own {
	public int maxProfit(int[] prices) {
		int n = prices.length;
		if (n < 2)
			return 0;
		int[] res = new int[n];
		for (int i = 1; i < n; i++) {
			if (prices[i] <= prices[i - 1])
				res[i] = res[i - 1];
			else {
				if (i == 1 || prices[i - 1] >= prices[i - 2])
					res[i] = res[i - 1]
							+ Math.max(0, prices[i] - prices[i - 1]);
				else {
					res[i] = Math.max(prices[i] - prices[i - 1], res[i - 2]);
					for (int j = 0; j < i; j++)
						res[i] = Math.max(res[i], (j > 1 ? res[j - 2] : 0)
								+ prices[i] - prices[j]);
					for (int j = 0; j < i - 2; j++)
						res[i] = Math.max(res[i], res[j] + prices[i]
								- prices[i - 1]);
				}
			}
		}
		return res[n - 1];
	}
}
