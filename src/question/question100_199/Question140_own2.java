package question.question100_199;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

//我尽力了，我用我的DP想法去做还是超时了
public class Question140_own2 {
	public List<String> wordBreak(String s, Set<String> wordDict) {
		int len = 0;
		for (String word : wordDict) {
			if (len < word.length())
				len = word.length();
		}
		List<String>[] dp = new ArrayList[s.length() + 1];
		dp[0] = new ArrayList<String>();
		dp[0].add("");
		for (int i = 1; i <= s.length(); i++) {
			dp[i] = new ArrayList<String>();
			for (int j = Math.max(0, i - len); j < i; j++) {
				if (dp[j].isEmpty())
					continue;
				String word = s.substring(j, i);
				if (wordDict.contains(word)) {
					for (String be : dp[j])
						dp[i].add(be.equals("") ? (word) : (be + " " + word));
				}
			}
		}
		return dp[s.length()];
	}
}
