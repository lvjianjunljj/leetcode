package question.question300_399;

/*
 * Write a function that takes a string as input and returns the string reversed.
 * Example:
 * Given s = "hello", return "olleh".
 */
//这道题一定有什么耗时更低且空间复杂度为O1的方法。
public class Question344_own {
	public String reverseString(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++)
			sb.append(s.charAt(s.length() - 1 - i));
		return sb.toString();
	}
}
