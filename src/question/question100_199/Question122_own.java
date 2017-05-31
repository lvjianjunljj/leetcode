package question.question100_199;

/*
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
 * (ie, buy one and sell one share of the stock multiple times). 
 * However, you may not engage in multiple transactions at the same time 
 * (ie, you must sell the stock before you buy again).
 */
//理好思路，找到每一条下降的路线然后将差值相加。
public class Question122_own {
	public int maxProfit(int[] prices) {
		int res = 0;
		boolean have = false;
		for (int i = 0; i < prices.length; i++) {
			if (have) {
				while (i < prices.length - 1 && prices[i + 1] >= prices[i])
					i++;
				res += prices[i];
				have = false;
			} else {
				while (i < prices.length - 1 && prices[i + 1] <= prices[i])
					i++;
				if (i < prices.length - 1) {
					res -= prices[i];
					have = true;
				}
			}
		}
		return res;
	}
}
