package question.question1_99;

/*
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * The number of ways decoding "12" is 2.
 */

//用动态规划做，本身思路并不难想，dp[i + 1]只有0，dp[i] + dp[i - 1]，dp[i]和 dp[i - 1]四种情况（因此dp的长度是n + 1）
//但每一种对应的具体需要细细分开所以显得很麻烦
public class Question91_own {
	public int numDecodings(String s) {
		int n = s.length();
		if (n == 0 || s.charAt(0) == '0')
			return 0;
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 1; i < n; i++) {
			if ((s.charAt(i - 1) == '0' || s.charAt(i - 1) > '2')
					&& s.charAt(i) == '0')
				return 0;
			else if ((s.charAt(i - 1) == '1' && s.charAt(i) > '0')
					|| (s.charAt(i - 1) == '2' && s.charAt(i) < '7' && s
							.charAt(i) > '0'))
				dp[i + 1] = dp[i] + dp[i - 1];
			else if (s.charAt(i - 1) > '0' && s.charAt(i) > '0')
				dp[i + 1] = dp[i];
			else
				dp[i + 1] = dp[i - 1];
		}
		return dp[n];
	}
}
