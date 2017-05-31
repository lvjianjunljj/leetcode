package question.question1_99;

/*
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * For example:
 * Given "25525511135",
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
import java.util.ArrayList;
import java.util.List;

//用回溯就能做出来，就是判断是否成立时需要考虑的情况还是有一点多的
public class Question93_own1 {
	public List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<String>();
		if (s.length() > 12)
			return res;
		dfs(res, s, new ArrayList<String>(), 0);
		return res;
	}

	private void dfs(List<String> res, String s, List<String> path, int index) {
		if ((path.size() > 0 && Integer.parseInt(path.get(path.size() - 1)) > 255)
				|| (path.size() > 0
						&& path.get(path.size() - 1).charAt(0) == '0' && path
						.get(path.size() - 1).length() > 1))
			return;
		if (path.size() == 4
				&& path.get(0).length() + path.get(1).length()
						+ path.get(2).length() + path.get(3).length() == s
						.length()) {
			res.add(path.get(0) + "." + path.get(1) + "." + path.get(2) + "."
					+ path.get(3));
			return;
		}
		for (int i = index + 1; i < Math.min(index + 4, s.length() + 1); i++) {
			path.add(s.substring(index, i));
			dfs(res, s, path, i);
			path.remove(path.size() - 1);
		}
	}
}
