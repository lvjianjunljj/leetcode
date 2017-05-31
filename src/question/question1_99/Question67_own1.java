package question.question1_99;

/*
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 */
//想类比371的方法去做，显然是想麻烦了
public class Question67_own1 {
	public String addBinary(String a, String b) {
		if (aux(b))
			return a;
		return addBinary(aux1(a, b), aux2(a, b) + "0");
	}

	private boolean aux(String s) {
		for (char c : s.toCharArray())
			if (c == '1')
				return false;
		return true;
	}

	private String aux1(String a, String b) {
		if (a.length() < b.length())
			return aux1(b, a);
		int m = a.length(), n = b.length();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m - n; i++)
			sb.append(a.charAt(i));
		for (int j = 0; j < n; j++)
			sb.append(a.charAt(m - n + j) == b.charAt(j) ? 0 : 1);
		int i = 0;
		while (i < sb.length() && sb.charAt(i) == '0')
			i++;
		return sb.substring(i).toString();
	}

	private String aux2(String a, String b) {
		if (a.length() < b.length())
			return aux2(b, a);
		int m = a.length(), n = b.length();
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < n; j++)
			sb.append((a.charAt(m - n + j) == '1' && b.charAt(j) == '1') ? 1
					: 0);
		int i = 0;
		while (i < sb.length() && sb.charAt(i) == '0')
			i++;
		return sb.substring(i).toString();
	}
}
