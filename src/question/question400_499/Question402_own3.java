package question.question400_499;

//用StringBuilder会再次降低耗时
public class Question402_own3 {
	public String removeKdigits(String num, int k) {
		if (num.length() == k)
			return "0";
		StringBuilder sb = new StringBuilder(num);
		while (k > 0) {
			boolean mark = true;
			for (int i = 1; i < sb.length(); i++)
				if (sb.charAt(i) < sb.charAt(i - 1)) {
					mark = false;
					int j = 1, end = Math.min(i, k);
					while (j <= end && sb.charAt(i - j) > sb.charAt(i))
						j++;
					sb.delete(i - j + 1, i);
					k = k - j + 1;
					break;
				}
			if (mark) {
				sb.delete(sb.length() - k, sb.length());
				k = 0;
			}
		}
		int i = 0;
		while (i < sb.length() - 1 && sb.charAt(i) == '0')
			i++;
		return sb.substring(i).toString();
	}
}
