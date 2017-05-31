package question.question1_99;

//用加'#'来规避奇偶的判断，初步的Manacher算法思想
public class Question05_own2 {
	public String longestPalindrome(String s) {
		if (s.length() <= 1)
			return s;
		char[] list = new char[s.length() * 2 + 1];
		for (int i = 0; i < s.length(); i++) {
			list[i * 2] = '#';
			list[i * 2 + 1] = s.charAt(i);
		}
		list[s.length() * 2] = '#';
		int len = 0, index = 0;
		for (int i = 0; i < list.length; i++) {
			int j = i - 1;
			for (; j >= 0 && j > i * 2 - list.length; j--) {
				if (list[j] != list[i * 2 - j])
					break;
			}
			if (len < i * 2 - j * 2 - 1) {
				len = i * 2 - j * 2 - 1;
				index = i;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = index - (len - 1) / 2; i <= index + (len - 1) / 2; i++)
			if (list[i] != '#')
				sb.append(list[i]);
		return sb.toString();
	}
}
