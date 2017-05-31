package question.question100_199;
/*
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * For example, given s = "aab",
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
//以为和question131一样用回溯一做就出来了，md数据量一大就超时了，没想到是用动态规划做啊。
public class Question132_own1 {
	int res = Integer.MAX_VALUE;

	public int minCut(String s) {
		dfs(s, 0, 0, 0);
		return res - 1;
	}

	private void dfs(String s, int index, int count, int cuts) {
		if (cuts >= res)
			return;
		if (count == s.length())
			res = cuts;
		for (int i = index; i < s.length(); i++) {
			if (isPalindrome(s, index, i + 1)) {
				dfs(s, i + 1, count + i + 1 - index, cuts + 1);
			}
		}
	}

	private boolean isPalindrome(String s, int i, int j) {
		String str = s.substring(i, j);
		char[] list = str.toCharArray();
		for (int k = 0; k < list.length / 2; k++)
			if (list[k] != list[list.length - 1 - k])
				return false;
		return true;
	}
}
