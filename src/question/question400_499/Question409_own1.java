package question.question400_499;

/*
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes 
 * that can be built with those letters.
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * Note:
 * Assume the length of given string will not exceed 1,010.
 * Example:
 * Input:
 * "abccccdd"
 * Output:
 * 7
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 */

//没想到还有什么更好的思路
public class Question409_own1 {
	public int longestPalindrome(String s) {
		int[] list = new int[58];
		boolean only = true;
		for (int i = 0; i < s.length(); i++)
			list[s.charAt(i) - 'A']++;
		int res = 0;
		for (int i = 0; i < 58; i++) {
			if (list[i] % 2 == 0)
				res += list[i];
			else {
				if (only) {
					res += list[i];
					only = false;
				} else
					res += list[i] - 1;
			}
		}
		return res;
	}
}
