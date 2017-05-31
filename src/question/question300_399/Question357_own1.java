package question.question300_399;

/*
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.
 * Example:
 * Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])
 */
//用数学的排列组合思路一下就能出来了
public class Question357_own1 {
	public int countNumbersWithUniqueDigits(int n) {
		int[] dp = new int[11];
		dp[0] = 1;
		int k = 9, s = 9;
		for (int i = 1; i < 11; i++) {
			dp[i] = s + dp[i - 1];
			s *= (k--);
		}
		return n < 11 ? dp[n] : dp[10];
	}
}
