package question.question200_299;

//这道题用KMP也是能做的，但是实在不想看了，有点难懂——others3也是一样
public class Question214_others2 {
	public String shortestPalindrome(String s) {
		String rev_s = new StringBuilder(s).reverse().toString();
		String l = s + "#" + rev_s;
		int[] p = new int[l.length()];
		for (int i = 1; i < l.length(); i++) {
			int j = p[i - 1];
			while (j > 0 && l.charAt(i) != l.charAt(j))
				j = p[j - 1];
			p[i] = (j += (l.charAt(i) == l.charAt(j) ? 1 : 0));
		}

		return rev_s.substring(0, s.length() - p[l.length() - 1]) + s;
	}
}a
