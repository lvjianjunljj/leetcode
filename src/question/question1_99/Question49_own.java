package question.question1_99;

/*
 * Given an array of strings, group anagrams together.
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
 * Return:
 [
 ["ate", "eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//就是两层遍历,判断，超时了
public class Question49_own {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<List<String>>();
		if (strs.length == 0)
			return res;
		List<HashMap<Character, Integer>> mapList = new ArrayList<HashMap<Character, Integer>>();
		boolean mark = true;
		for (String str : strs) {
			mark = true;
			char[] array = str.toCharArray();
			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			for (int i = 0; i < array.length; i++) {
				map.put(array[i],
						map.containsKey(array[i]) ? map.get(array[i]) + 1 : 1);
			}
			for (int i = 0; i < mapList.size(); i++) {
				if (agree(map, mapList.get(i))) {
					res.get(i).add(str);
					mark = false;
					break;
				}
			}
			if (mark) {
				ArrayList<String> curList = new ArrayList<String>();
				curList.add(str);
				res.add(curList);
				mapList.add(map);
			}
		}
		return res;
	}

	public boolean agree(HashMap<Character, Integer> map1,
			HashMap<Character, Integer> map2) {
		for (Character str : map1.keySet())
			if (!(map2.containsKey(str) && map1.get(str) == map2.get(str)))
				return false;
		for (Character str : map2.keySet())
			if (!(map1.containsKey(str) && map2.get(str) == map1.get(str)))
				return false;
		return true;
	}
}
