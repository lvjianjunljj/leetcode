package question.question1_99;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//思路和others5是一样的，但是这样写耗时确实更低了——19到16行的这种写法耗时更低
public class Question49_others6 {
	public List<List<String>> groupAnagrams(String[] strs) {
		int[] prime = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53,
				59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103 };
		List<List<String>> res = new ArrayList<List<String>>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (String s : strs) {
			int key = 1;
			for (char i : s.toCharArray())
				key *= prime[i - 'a'];
			List<String> t;
			if (map.containsKey(key)) {
				t = res.get(map.get(key));
			} else {
				t = new ArrayList<String>();
				res.add(t);
				map.put(key, res.size() - 1);
			}
			t.add(s);
		}
		return res;
	}
}
