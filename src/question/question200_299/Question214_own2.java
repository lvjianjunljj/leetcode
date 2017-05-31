package question.question200_299;

//反转直接一起加到左端就行，不用一个一个字符的加
public class Question214_own2 {
	public String shortestPalindrome(String s) {
		int index = 0;
		for (int i = s.length() - 1; i >= 0; i--)
			if (isPalindrome(s, i)) {
				index = i;
				break;
			}
		if (index < s.length() - 1)
			return new StringBuilder(s.substring(index + 1)).reverse()
					.toString()
					+ s;
		return s;
	}

	private boolean isPalindrome(String s, int index) {
		for (int i = 0; i < (index + 1) / 2; i++)
			if (s.charAt(i) != s.charAt(index - i))
				return false;
		return true;
	}
}
