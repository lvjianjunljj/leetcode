package question.question100_199;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//用两个HashSet耗时确实低，而且用位运算没必要每次都把20位二进制数全部算一遍
//可以左移两位之后将最左边两位置零，然后再将后两位加上就是下一串DNA对应的数
public class Question187_others3 {
	public List<String> findRepeatedDnaSequences(String s) {
		List<String> res = new ArrayList<String>();
		if (s.length() < 10)
			return res;
		HashSet<Integer> set = new HashSet<Integer>();
		HashSet<Integer> reset = new HashSet<Integer>();
		int[] map = new int[26];
		map['C' - 'A'] = 1;
		map['G' - 'A'] = 2;
		map['T' - 'A'] = 3;
		int num = 0;
		for (int i = 0; i < 10; i++) {
			num <<= 2;
			num |= map[s.charAt(i) - 'A'];
		}
		set.add(num);
		for (int i = 10; i < s.length(); i++) {
			num <<= 2;
			num |= map[s.charAt(i) - 'A'];
			num &= 0xfffff;
			if (!set.add(num) && reset.add(num))
				res.add(s.substring(i - 9, i + 1));
		}

		return res;
	}
}
