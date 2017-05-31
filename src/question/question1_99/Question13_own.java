package question.question1_99;
/*
 * Given a roman numeral, convert it to an integer.
 */

//根据12题的思路才能做出来这种写法，其实并不是非常好
public class Question13_own {
	public int romanToInt(String s) {
		String[] th = { "M", "MM", "MMM" };
		String[] hu = { "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
		String[] te = { "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
		String[] on = { "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
		return aux(s, th, hu, te, on);
	}

	private int aux(String s, String[] th, String[] hu, String[] te, String[] on) {
		if (s.length() == 0) {
			return 0;
		}
		if (s.charAt(0) == 'M') {
			for (int i = 2; i >= 0; i--) {
				if (s.length() >= th[i].length()
						&& s.substring(0, th[i].length()).equals(th[i])) {
					return 1000
							* (i + 1)
							+ aux(s.substring(th[i].length(), s.length()), th,
									hu, te, on);
				}
			}
		} else if (s.charAt(0) == 'C' || s.charAt(0) == 'D') {
			for (int i = 8; i >= 0; i--) {
				if (s.length() >= hu[i].length()
						&& s.substring(0, hu[i].length()).equals(hu[i])) {
					return 100
							* (i + 1)
							+ aux(s.substring(hu[i].length(), s.length()), th,
									hu, te, on);
				}
			}
		} else if (s.charAt(0) == 'X' || s.charAt(0) == 'L') {
			for (int i = 8; i >= 0; i--) {
				if (s.length() >= te[i].length()
						&& s.substring(0, te[i].length()).equals(te[i])) {
					return 10
							* (i + 1)
							+ aux(s.substring(te[i].length(), s.length()), th,
									hu, te, on);
				}
			}
		} else {
			for (int i = 8; i >= 0; i--) {
				if (s.length() >= on[i].length()
						&& s.substring(0, on[i].length()).equals(on[i])) {
					return (i + 1)
							+ aux(s.substring(on[i].length(), s.length()), th,
									hu, te, on);
				}
			}
		}
		return 0;
	}
}
