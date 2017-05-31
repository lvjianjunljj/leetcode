package question.question1_99;

/*
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 */
//想装逼地用递归调用其本身，结果发现耗时极高，非常不实用
public class Question05_own1 {
	public String longestPalindrome(String s) {
		if (s.length() <= 1)
			return s;
		if (isPalindromic(s))
			return s;
		String behind = longestPalindrome(s.substring(0, s.length() - 1));
		String after = longestPalindrome(s.substring(1, s.length()));
		return behind.length() > after.length() ? behind : after;
	}

	private boolean isPalindromic(String str) {
		for (int i = 0; i < str.length() / 2; i++)
			if (str.charAt(i) != str.charAt(str.length() - 1 - i))
				return false;
		return true;
	}
}
