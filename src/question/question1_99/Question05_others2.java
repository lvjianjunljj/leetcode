package question.question1_99;
//用这种方法耗时居然很低，只能说明数据量不够大
public class Question05_others2 {
	private int low = 0, maxLen = 0;

	public String longestPalindrome(String s) {
		for (int i = 0; i < s.length(); i++) {
			aux(s, i, i);
			aux(s, i, i + 1);
		}
		return s.substring(low, low + maxLen);
	}

	private void aux(String s, int i, int j) {
		while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
			i--;
			j++;
		}
		if (maxLen < j - i - 1) {
			maxLen = j - i - 1;
			low = i + 1;
		}
	}
}
