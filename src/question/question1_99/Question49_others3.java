package question.question1_99;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//根据网上最快的方法和others2想法结合一下，用前26个质数之积来代替每一组的标志——耗时确实减小了
public class Question49_others3 {
	public List<List<String>> groupAnagrams(String[] strs) {
		int[] prime = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53,
				59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103 };// 最多10609个z
		List<List<String>> res = new ArrayList<List<String>>();
		HashMap<Integer, List<String>> map = new HashMap<Integer, List<String>>();
		for (String s : strs) {
			int key = 1;
			for (char c : s.toCharArray()) {
				key *= prime[c - 'a'];
			}
			if (!map.containsKey(key))
				map.put(key, new ArrayList<String>());
			map.get(key).add(s);
		}
		return new ArrayList<List<String>>(map.values());
	}
}
