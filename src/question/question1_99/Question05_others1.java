package question.question1_99;

//用Manacher算法，耗时确实降低了一些
public class Question05_others1 {
	public String longestPalindrome(String s) {
		StringBuilder newStr = new StringBuilder();
		newStr.append('#');
		for (int i = 0; i < s.length(); i++) {
			newStr.append(s.charAt(i));
			newStr.append('#');
		}
		int[] rad = new int[newStr.length()];
		int right = -1;
		int id = -1;
		for (int i = 0; i < newStr.length(); i++) {
			int r = 0;
			if (i <= right)
				r = Math.min(right - i, rad[id * 2 - i]);
			while (i - r >= 0 && i + r < newStr.length()
					&& newStr.charAt(i - r) == newStr.charAt(i + r))
				r++;
			if (i + r - 1 > right) {
				right = i + r - 1;
				id = i;
			}
			rad[i] = r;
		}
		int maxLen = 0, index = 0;
		for (int i = 0; i < rad.length; i++) {
			if (maxLen < rad[i]) {
				maxLen = rad[i];
				index = i;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = index - maxLen + 1; i < index + maxLen - 1; i++)
			if (newStr.charAt(i) != '#')
				sb.append(newStr.charAt(i));
		return sb.toString();
	}
}
