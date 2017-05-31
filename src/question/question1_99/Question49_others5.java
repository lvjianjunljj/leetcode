package question.question1_99;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//这个方法才是耗时最低且空间复杂度最低的方法——简直是美妙——美妙个屁，当String过长时很有可能出现错误
public class Question49_others5 {
	public List<List<String>> groupAnagrams(String[] strs) {
		int[] prime = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53,
				59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103 };
		List<List<String>> res = new ArrayList<List<String>>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (String str : strs) {
			int key = 1;
			for (char i : str.toCharArray())
				key *= prime[i - 'a'];
			if (!map.containsKey(key)) {
				map.put(key, res.size());
				res.add(new ArrayList<String>());
			}
			res.get(map.get(key)).add(str);
		}
		return res;
	}
}
