package question.question1_99;
//代码更简洁了，但是时间复杂度并没有降低太多
public class Question14_others {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		for (int i = 0; i < strs[0].length(); i++) {
			char c = strs[0].charAt(i);
			for (String s : strs)
				if (s.length() == i || s.charAt(i) != c)
					return strs[0].substring(0, i);
		}
		return strs[0];
	}
}
