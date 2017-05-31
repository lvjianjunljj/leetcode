package question.question1_99;

/*
 * You are given a string, s, and a list of words, words, that are all of the same length. 
 * Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once 
 * and without any intervening characters.
 * For example, given:
 * s:"barfoothefoobarman"
 * words: ["foo", "bar"]
 * You should return the indices: [0,9].
 * (order does not matter).
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//遍历整个String，一位一位向后移然后重新比较确实会超时，需要改进一下，将每次判断的数据存储一下避免重复判断
public class Question30_own1 {
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res = new ArrayList<Integer>();
		int len = words.length;
		int eLen = words[0].length(), sumLen = eLen * len;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (String word : words) {
			if (!map.containsKey(word))
				map.put(word, 1);
			else
				map.put(word, map.get(word) + 1);
		}
		for (int i = 0; i <= s.length() - sumLen; i++)
			if (judge(s.substring(i), (HashMap<String, Integer>) map.clone(),
					eLen, len))
				res.add(i);
		return res;
	}

	private boolean judge(String s, HashMap<String, Integer> map, int eLen,
			int len) {
		for (int i = 0; i < len; i++) {
			String str = s.substring(i * eLen, i * eLen + eLen);
			if (!map.containsKey(str))
				return false;
			if (map.get(str) == 1)
				map.remove(str);
			else
				map.put(str, map.get(str) - 1);
		}
		return true;
	}
}
