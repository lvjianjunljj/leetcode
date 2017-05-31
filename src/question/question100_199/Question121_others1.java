package question.question100_199;

/*
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * Example 1:
 * Input: [7, 1, 5, 3, 6, 4]
 * Output: 5
 * max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
 * Example 2:
 * Input: [7, 6, 4, 3, 1]
 * Output: 0
 * In this case, no transaction is done, i.e. max profit = 0.
 */

//这才是这道题应该有的解法，两层循环就不要写出来丢人了，确实要用数学思维好好想明白
public class Question121_others1 {
	public int maxProfit(int[] prices) {
		int min = Integer.MAX_VALUE, res = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < min)
				min = prices[i];
			else
				res = Math.max(res, prices[i] - min);
		}
		return res;
	}
}
