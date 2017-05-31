package question.question1_99;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//将每次判断的数据存储一下避免重复判断，这样才能不超时，但感觉并不是特别好
public class Question30_own2 {
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res = new ArrayList<Integer>();
		int len = words.length;
		int eLen = words[0].length(), sumLen = eLen * len;
		HashMap<String, Boolean> data = new HashMap<String, Boolean>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (String word : words) {
			if (!map.containsKey(word))
				map.put(word, 1);
			else
				map.put(word, map.get(word) + 1);
		}
		for (int i = 0; i <= s.length() - sumLen; i++) {
			String sub = s.substring(i, i + sumLen);
			if (data.containsKey(sub)) {
				if (data.get(sub))
					res.add(i);
			} else {
				if (judge(sub, (HashMap<String, Integer>) map.clone(), eLen,
						len)) {
					res.add(i);
					data.put(sub, true);
				} else
					data.put(sub, false);
			}
		}
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
