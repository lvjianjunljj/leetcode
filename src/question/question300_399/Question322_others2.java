package question.question300_399;

import java.util.Arrays;

//这个方法只要3ms，而我们的方法要30+ms，用递归实现动态规划，感觉比较有新意
public class Question322_others2 {
	int total = Integer.MAX_VALUE;

	public int coinChange(int[] coins, int amount) {
		if (amount == 0)
			return 0;
		Arrays.sort(coins);
		count(amount, coins.length - 1, coins, 0);
		return total == Integer.MAX_VALUE ? -1 : total;
	}

	void count(int amount, int index, int[] coins, int count) {
		if (index < 0 || count >= total - 1)
			return;
		int c = amount / coins[index];
		for (int i = c; i >= 0; i--) {
			int newCount = count + i;
			int rem = amount - i * coins[index];

			if (rem > 0 && newCount < total)
				count(rem, index - 1, coins, newCount);
			else if (newCount < total)
				total = newCount;
			else
				break;
		}
	}
}
