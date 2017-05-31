package question.question1_99;
//这才是最正规也是最无聊的做法
public class Question67_own2 {
	public String addBinary(String a, String b) {
		if (a.length() < b.length())
			return addBinary(b, a);
		int m = a.length(), n = b.length(), c = 0;
		char[] list = new char[m];
		for (int i = m - 1; i >= 0; i--) {
			int first = a.charAt(i) - '0';
			int second = i - m + n >= 0 ? b.charAt(i - m + n) - '0' : 0;
			list[i] = (char) ((first + second + c) % 2 + '0');
			c = (first + second + c) / 2;
		}
		return (c == 1 ? "1" : "") + (new String(list));
	}
}
