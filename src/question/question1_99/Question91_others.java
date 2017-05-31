package question.question1_99;

//像这种写法才是最简练的——两个数一起判断，简直美妙（特别是那一句continue简直美妙）
public class Question91_others {
	public int numDecodings(String s) {
		int n = s.length();
		if (n == 0)
			return 0;
		int[] dp = new int[n + 1];
		dp[n] = 1;
		dp[n - 1] = s.charAt(n - 1) == '0' ? 0 : 1;
		for (int i = n - 2; i >= 0; i--) {
			if (s.charAt(i) == '0')
				continue;
			dp[i] = Integer.parseInt(s.substring(i, i + 2)) < 27 ? dp[i + 1]
					+ dp[i + 2] : dp[i + 1];
		}
		return dp[0];
	}
}
