package question.question100_199;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

//想用回溯就必须用这种带记忆的回溯做才行了，通过答案给的思路再加上维护一个len值使耗时更加降低了。
public class Question140_others {
	public List<String> wordBreak(String s, Set<String> wordDict) {
		int len = 0;
		for (String word : wordDict) {
			if (len < word.length())
				len = word.length();
		}
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		return dfs(s, wordDict, map, len);
	}

	private List<String> dfs(String s, Set<String> wordDict,
			HashMap<String, List<String>> map, int len) {
		if (map.containsKey(s))
			return map.get(s);
		List<String> res = new ArrayList<String>();
		if (s.equals(""))
			res.add("");
		for (int i = 0; i < Math.min(s.length(), len); i++) {
			String word = s.substring(0, i + 1);
			if (wordDict.contains(word)) {
				List<String> nexts = dfs(s.substring(i + 1), wordDict, map, len);
				for (String next : nexts) {
					res.add(word + (next.equals("") ? "" : " ") + next);
				}
			}
		}
		map.put(s, res);
		return res;
	}
}
