package question.question100_199;

import java.util.ArrayList;
import java.util.List;

//优化了封装的判断方法isPalindrome耗时果然降低了很多
public class Question131_own2 {
	public List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<List<String>>();
		dfs(res, s, new ArrayList<String>(), 0, 0);
		return res;
	}

	private void dfs(List<List<String>> res, String s, List<String> path,
			int count, int index) {
		if (count == s.length())
			res.add(new ArrayList<String>(path));
		for (int i = index; i < s.length(); i++) {
			if (isPalindrome(s, index, i + 1)) {
				path.add(s.substring(index, i + 1));
				dfs(res, s, path, count + i + 1 - index, i + 1);
				path.remove(path.size() - 1);
			}
		}
	}

	private boolean isPalindrome(String s, int i, int j) {
		for (int k = i; k < (i + j) / 2; k++)
			if (s.charAt(k) != s.charAt(i + j - 1 - k))
				return false;
		return true;
	}
}
