package question.question1_99;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//对others1的算法进行优化，耗时确实很低
public class Question49_others2 {
	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		for (String str : strs) {
			char[] list = str.toCharArray();
			Arrays.sort(list);
			String tmp = String.valueOf(list);
			if (!map.containsKey(tmp))
				map.put(tmp, new ArrayList<String>());
			map.get(tmp).add(str);
		}
		return new ArrayList<List<String>>(map.values());
	}
}
