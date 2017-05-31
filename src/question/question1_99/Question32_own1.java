package question.question1_99;

//用数组做也是可以的，类似山峰宽度的计算，完美
public class Question32_own1 {
	public int longestValidParentheses(String s) {
		int[] counts = new int[s.length() + 1];
		int k = 1, res = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				counts[k] = counts[k - 1] + 1;
			} else {
				counts[k] = counts[k - 1] - 1;
			}
			k++;
		}
		int start = 0, end = s.length();
		for (int i = 0; i < counts.length; i++) {
			if (counts[i] == counts[start] && res < i - start) {
				res = i - start;
			}
			if (counts[i] < counts[start]) {
				start = i;
			}
		}
		for (int i = s.length(); i >= 0; i--) {
			if (counts[i] == counts[end] && res < end - i) {
				res = end - i;
			}
			if (counts[i] < counts[end]) {
				end = i;
			}
		}
		return res;
	}
}
