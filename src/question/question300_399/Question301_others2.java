package question.question300_399;

import java.util.ArrayList;
import java.util.List;

//这道题用DFS也是能做的，先找到第一个不符合的点然后遍历其之前的char来操作，
//它的这个reverse方法用的直接就能省略了判断的过程——我直接就想给他跪下，美妙啊
public class Question301_others2 {
	public List<String> removeInvalidParentheses(String s) {
		List<String> res = new ArrayList<String>();
		dfs(res, s, 0, 0, new char[] { '(', ')' });
		return res;
	}

	private static void dfs(List<String> res, String s, int iLast, int jLast,
			char[] list) {
		int count = 0;
		for (int i = iLast; i < s.length(); i++) {
			if (s.charAt(i) == list[0])
				count++;
			if (s.charAt(i) == list[1])
				count--;
			if (count >= 0)
				continue;
			for (int j = jLast; j <= i; j++)
				if (s.charAt(j) == list[1]
						&& (j == jLast || s.charAt(j - 1) != list[1]))
					dfs(res, s.substring(0, j) + s.substring(j + 1), i, j, list);
			return;
		}
		String reverse = new StringBuilder(s).reverse().toString();
		if (list[0] == '(')
			dfs(res, reverse, 0, 0, new char[] { ')', '(' });
		else
			res.add(reverse);
	}
}
