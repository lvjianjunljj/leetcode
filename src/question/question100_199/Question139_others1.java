package question.question100_199;

import java.util.Set;
/*
 * Given a string s and a dictionary of words dict, 
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 */
//这里的方法也是动态规划，并不是很难理解
public class Question139_others1{
	//这道题需要用DFS来做，有点困难
	public boolean wordBreak(String s, Set<String> wordDict) {
		if (s == null || s.length() == 0) {
			return false;
		}
		int maxLength = maxLengthStr(wordDict);
		return dfs(s, 0, wordDict, new boolean[s.length()], maxLength);
	}

	private boolean dfs(String s, int idx, Set<String> wordDict,
			boolean[] unbreakable, int maxLength) {
		if (idx >= s.length()) {
			return true;
		} else if (unbreakable[idx]) {
			return false;
		} else {
			int end = Math.min(idx + maxLength, s.length());
			for (int i = idx + 1; i <= end; i++) {
				if (wordDict.contains(s.substring(idx, i))) {
					if (dfs(s, i, wordDict, unbreakable, maxLength)) {
						return true;
					}
				}
			}
			unbreakable[idx] = true;
			return false;
		}
	}

	private int maxLengthStr(Set<String> wordDict) {
		int max = 0;
		for (String str : wordDict) {
			max = Math.max(max, str.length());
		}
		return max;
	}
}
