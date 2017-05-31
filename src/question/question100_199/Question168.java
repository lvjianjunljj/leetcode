package question.question100_199;
/*
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 */
public class Question168 {
	public String convertToTitle(int n) {
		int a = 'A';
		String result = "";
		while (n > 0) {
			result = (char) ((n - 1) % 26 + a) + result;
			n = (n - 1) / 26;
		}
		return result;
	}
}
