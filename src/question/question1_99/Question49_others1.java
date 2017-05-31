package question.question1_99;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//用这种HashMap做才是最正统的方法。
public class Question49_others1 {
	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		for (String str : strs) {
			char[] list = str.toCharArray();
			Arrays.sort(list);
			if (!map.containsKey(new String(list)))
				map.put(new String(list), new ArrayList<String>());
			map.get(new String(list)).add(str);
		}
		List<List<String>> res = new ArrayList<List<String>>();
		for (String str : map.keySet())
			res.add(map.get(str));
		return res;
	}
}
