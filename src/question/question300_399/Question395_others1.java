package question.question300_399;

/*
 * Find the length of the longest substring T of a given string (consists of lowercase letters only) 
 * such that every character in T appears no less than k times.
 * Example 1:
 * Input:
 * s = "aaabb", k = 3
 * Output:
 * 3
 * The longest substring is "aaa", as 'a' is repeated 3 times.
 * Example 2:
 * Input:
 * s = "ababbc", k = 2
 * Output:
 * 5
 * The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 */

//我以为这道题是用DP做的，没想到使用分治来做，我的思路还是不够明确——确实应该是用分治的
//对于一段String整体判断检索出不符合的字符，然后找到第一个对其左右两边分别计算取大值（符合要求的sub一定不包含这个字符）
public class Question395_others1 {
	public int longestSubstring(String s, int k) {
		char[] list = s.toCharArray();
		return aux(list, 0, list.length - 1, k);
	}

	private int aux(char[] list, int start, int end, int k) {
		if (end - start + 1 < k)
			return 0;
		char[] alp = new char[26];
		for (int i = start; i <= end; i++)
			alp[list[i] - 'a']++;
		for (int i = 0; i < 26; i++) {
			if (alp[i] == 0)
				continue;
			if (alp[i] < k) {
				for (int j = start; j <= end; j++) {
					if (list[j] == i + 'a') {
						return Math.max(aux(list, start, j - 1, k), aux(list,
								j + 1, end, k));
					}
				}
			}
		}
		return end - start + 1;
	}
}
