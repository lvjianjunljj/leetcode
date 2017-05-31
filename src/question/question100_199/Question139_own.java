package question.question100_199;

import java.util.Set;
//其实用动态规划来做会好理解很多（这是我受了提示的启发写出来的动态规划，但是耗时比others2高很多，不知道为什么）
public class Question139_own {
	public boolean wordBreak(String s, Set<String> wordDict) {
		if (wordDict.size() == 0)
			return false;
		boolean[] res = new boolean[s.length()];
		for (int i = 0; i < res.length; i++) {
			if (wordDict.contains(s.substring(0, i + 1))) {
				res[i] = true;
				continue;
			}
			for (int j = 0; j < i; j++) {
				if (res[j] && wordDict.contains(s.substring(j + 1, i + 1))) {
					res[i] = true;
					break;
				}
			}
		}
		for (boolean i : res)
			System.out.println(i);
		return res[s.length() - 1];
	}
}
a