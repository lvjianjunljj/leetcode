package question.question1_99;

/*
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. 
 * (each operation is counted as 1 step.)
 * You have the following 3 operations permitted on a word:
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 */

//不要被这道题的题意吓到，其实有了思路以后用动态规划很快就能做出来，维护一个二维数组就结束了，简直是简单
public class Question72_others1 {
	public int minDistance(String word1, String word2) {
		int m = word1.length(), n = word2.length();
		int[][] s = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++)
			s[i][0] = i;
		for (int i = 0; i <= n; i++)
			s[0][i] = i;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				int a = s[i - 1][j];
				int b = s[i][j - 1];
				int c = s[i - 1][j - 1];
				if (word1.charAt(i - 1) == word2.charAt(j - 1))
					s[i][j] = c;
				else {
					s[i][j] = Math.min(a, Math.min(b, c)) + 1;
				}
			}
		}
		return s[m][n];
	}
}
