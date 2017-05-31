package question.question1_99;
//显然这道题不太适合用动态规划来做，耗时很高
public class Question05_others3 {
	public String longestPalindrome(String s) {
		String res = "";
		int n = s.length();
		boolean[][] dp = new boolean[n][n];
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i; j < n; j++) {
				if (s.charAt(i) == s.charAt(j)
						&& (j - i < 3 || dp[i + 1][j - 1])) {
					dp[i][j] = true;
					if (j - i + 1 > res.length())
						res = s.substring(i, j + 1);
				}
			}
		}
		return res;
	}
}
