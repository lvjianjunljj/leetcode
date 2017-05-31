package question.question200_299;

/*
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 */
//这道题和322很相似，用322中的使用递归实现动态规划耗时确实低很多，感觉棒棒哒
public class Question279_own {
	int total = Integer.MAX_VALUE;

	public int numSquares(int n) {
		int m = (int) Math.sqrt(n);
		int[] nums = new int[m];
		for (int i = 0; i < m; i++)
			nums[i] = (i + 1) * (i + 1);
		count(n, m - 1, nums, 0);
		return total;
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
