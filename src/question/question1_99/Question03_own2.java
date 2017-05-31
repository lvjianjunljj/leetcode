package question.question1_99;

import java.util.HashSet;
import java.util.Set;

//这道题显然用HashSet做快一点
public class Question03_own2 {
	public int lengthOfLongestSubstring(String s) {
		int i = 0, j = 0, res = 0;
		Set<Character> set = new HashSet<Character>();
		while (i < s.length()) {
			char c = s.charAt(i);
			while (set.contains(c)) {
				set.remove(s.charAt(j++));
			}
			set.add(c);
			i++;
			if (res < i - j) {
				res = i - j;
			}
		}
		return res;
	}
}
