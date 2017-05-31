package question.question100_199;

//思路是一样的，将代码简化了,任何增长都是可以变成收益的，所以直接这样做就行
public class Question122_others1 {
	public int maxProfit(int[] prices) {
		int res = 0;
		if (prices.length <= 1)
			return res;
		for (int i = 1; i < prices.length; i++)
			if (prices[i] > prices[i - 1])
				res += prices[i] - prices[i - 1];
		return res;
	}
}
