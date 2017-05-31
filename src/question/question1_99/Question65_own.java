package question.question1_99;

/*
 * Validate if a given string is numeric.
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * Note: It is intended for the problem statement to be ambiguous. 
 * You should gather all requirements up front before implementing one.
 */

//完全就是一点一点试出来的，没有什么技术含量
public class Question65_own {
	public boolean isNumber(String s) {
		s = s.trim();
		if (judge1(s))
			return true;
		boolean haveE = false;
		int index = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'e') {
				haveE = true;
				index = i;
			}
		}
		if (!haveE)
			return false;
		return judge1(s.substring(0, index))
				&& judge2(s.substring(index + 1, s.length()));
	}

	private boolean judge1(String s) {
		if (s.length() > 0 && (s.charAt(0) == '-' || s.charAt(0) == '+'))
			s = s.substring(1);
		if (s.length() == 0
				|| !((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.'))
			return false;
		boolean point = false;
		for (int i = 0; i < s.length(); i++) {
			if ((s.charAt(i) >= '0' && s.charAt(i) <= '9'))
				continue;
			else if (s.charAt(i) == '.') {
				if (point)
					return false;
				point = true;
			} else
				return false;
		}
		if (point && s.length() == 1)
			return false;
		return true;
	}

	private boolean judge2(String s) {
		if (s.length() > 0 && (s.charAt(0) == '-' || s.charAt(0) == '+'))
			s = s.substring(1);
		if (s.length() == 0)
			return false;
		for (int i = 0; i < s.length(); i++) {
			if ((s.charAt(i) >= '0' && s.charAt(i) <= '9'))
				continue;
			else
				return false;
		}
		return true;
	}
}
