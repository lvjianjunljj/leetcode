package question.question1_99;

//从两边向中间靠拢（以高度较高的点开始向中间靠拢），一边循环就可以了，耗时确实低了。。吊
public class Question32_own2 {
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
		while (start < end) {
			if (counts[start] > counts[end]) {
				int cur = start;
				while (cur <= end && counts[cur] >= counts[start]) {
					if (counts[cur] == counts[start] && res < cur - start) {
						res = cur - start;
					}
					cur++;
				}
				start = cur;
			} else {
				int cur = end;
				while (cur >= start && counts[cur] >= counts[end]) {
					if (counts[cur] == counts[end] && res < end - cur) {
						res = end - cur;
					}
					cur--;
				}
				end = cur;
			}
		}
		return res;
	}
}
