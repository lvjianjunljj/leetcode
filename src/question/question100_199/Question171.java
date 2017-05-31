package question.question100_199;
/*
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 */
public class Question171 {
	public int titleToNumber(String s) {
		char a = 'A' - 1;
		char[] list = s.toCharArray();
		int n = list.length;
		int result = 0;
		for (int i = 0; i < n; i++) {
			result += Math.pow(26, n - 1 - i) * ((int) list[i] - (int) a);
		}
		return result;
	}
}
