package question.question200_299;

/*
 * Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. 
 * Find and return the shortest palindrome you can find by performing this transformation.
 * For example:
 * Given "aacecaaa", return "aaacecaaa".
 * Given "abcd", return "dcbabcd".
 */

//我能想到的方法就是找到以最左端开始的最长回文然后再将右端反转补齐到左端
public class Question214_own1 {
	public String shortestPalindrome(String s) {
		int index = 0;
		for (int i = s.length() - 1; i >= 0; i--)
			if (isPalindrome(s, i)) {
				index = i;
				break;
			}
		StringBuilder sb = new StringBuilder(s);
		for (int i = index + 1; i < s.length(); i++)
			sb.insert(0, s.charAt(i));
		return sb.toString();
	}

	private boolean isPalindrome(String s, int index) {
		for (int i = 0; i < (index + 1) / 2; i++)
			if (s.charAt(i) != s.charAt(index - i))
				return false;
		return true;
	}
}
