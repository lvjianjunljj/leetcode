package question.question1_99;

import java.util.ArrayList;
import java.util.List;
//其实就是把一串String分成四段分别判断，用三层for循环远比用回溯耗时低
public class Question93_own2 {
	public List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<String>();
		int len = s.length();
		for (int i = 1; i < Math.min(4, len - 2); i++) {
			String first = s.substring(0, i);
			if (isValid(first)) {
				for (int j = i + 1; j < Math.min(i + 4, len - 1); j++) {
					String second = s.substring(i, j);
					if (isValid(second)) {
						for (int k = j + 1; k < Math.min(j + 4, len); k++) {
							String third = s.substring(j, k);
							String forth = s.substring(k, len);
							if (isValid(third) && isValid(forth))
								res.add(first + "." + second + "." + third
										+ "." + forth);
						}
					}
				}
			}
		}
		return res;
	}

	private boolean isValid(String s) {
		return !(s.length() > 3 || (s.charAt(0) == '0' && s.length() > 1) || Integer
				.parseInt(s) > 255);
	}
}
