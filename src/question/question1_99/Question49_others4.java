package question.question1_99;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//根据网上最快的方法和others2想法结合一下，用res的索引来代替每一组的List<String>存储
//直接在遍历的时候将每一个String加入到对应的res的某一个List中——空间复杂度确实减小了，但对于耗时没有什么影响（不会减小）
public class Question49_others4 {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<List<String>>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (String str : strs) {
			char[] list = str.toCharArray();
			Arrays.sort(list);
			String tmp = String.valueOf(list);
			if (!map.containsKey(tmp)) {
				map.put(tmp, res.size());
				res.add(new ArrayList<String>());
			}
			res.get(map.get(tmp)).add(str);
		}
		return res;
	}
}
