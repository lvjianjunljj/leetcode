package question.question100_199;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/*
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence 
 * where each word is a valid dictionary word.
 * Return all such possible sentences.
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * A solution is ["cats and dog", "cat sand dog"].
 */

//用回溯做，尝试了各种降低耗时的方式依然还是超时，看来以我的能力只能用DP做了
public class Question140_own1 {
	public List<String> wordBreak(String s, Set<String> wordDict) {
		int len = 0;
		boolean[] list = new boolean[26];
		for (int i = 0; i < s.length(); i++)
			list[s.charAt(i) - 'a'] = true;
		for (String word : wordDict) {
			for (int j = 0; j < word.length(); j++)
				list[word.charAt(j) - 'a'] = false;
			if (len < word.length())
				len = word.length();
		}
		List<String> res = new ArrayList<String>();
		for (boolean judge : list)
			if (judge)
				return res;
		dfs(s, res, wordDict, new StringBuilder(), 0, len);
		return res;
	}

	private void dfs(String s, List<String> res, Set<String> wordDict,
			StringBuilder path, int start, int len) {
		if (start == s.length())
			res.add(path.substring(1).toString());
		for (int i = start; i < Math.min(s.length(), start + len); i++) {
			String word = s.substring(start, i + 1);
			if (wordDict.contains(word)) {
				path.append(" " + word);
				dfs(s, res, wordDict, path, i + 1, len);
				path.delete(path.length() - word.length() - 1, path.length());
			}
		}
	}
}
