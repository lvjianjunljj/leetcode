package question.question1_99;

import java.util.ArrayList;
import java.util.List;

//这么写才比较简洁
public class Question17_own2 {
	public List<String> letterCombinations(String digits) {
		String[] list = new String[] { "abc", "def", "ghi", "jkl", "mno",
				"pqrs", "tuv", "wxyz" };
		List<String> res = new ArrayList<String>();
		if (digits.length() < 1) {
			return res;
		}
		dfs(res, list, new StringBuilder(), digits, 0);
		return res;
	}

	private void dfs(List<String> res, String[] list, StringBuilder sb,
			String digits, int index) {
		if (index == digits.length()) {
			res.add(sb.toString());
			return;
		}
		int i = digits.charAt(index) - '2';
		for (char c : list[i].toCharArray()) {
			sb.append(c);
			dfs(res, list, sb, digits, index + 1);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}
