package question.question100_199;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//也要用HashMap存值，但是其实一共才出现4个字符，所以一个10位长的字符串可以封装成一个20位的二进制数，耗时其实并没有降低多少，但至少要知道这种思路
public class Question187_others1 {
	public List<String> findRepeatedDnaSequences(String s) {
		List<String> res = new ArrayList<String>();
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		int len = s.length();
		int[] nums = new int[26];
		nums['C' - 'A'] = 1;
		nums['G' - 'A'] = 2;
		nums['T' - 'A'] = 3;
		for (int i = 0; i < len - 9; i++) {
			int value = 0;
			for (int j = 0; j < 10; j++) {
				value <<= 2;
				value |= nums[s.charAt(i + j) - 'A'];
			}
			if (!map.containsKey(value))
				map.put(value, true);
			else {
				if (map.get(value))
					res.add(s.substring(i, i + 10));
				map.put(value, false);
			}
		}
		return res;
	}
}
