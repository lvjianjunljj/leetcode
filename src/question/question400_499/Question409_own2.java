package question.question400_499;

import java.util.HashSet;

//提示给的是HashSet，但没想到耗时更长，没意思
public class Question409_own2 {
	public int longestPalindrome(String s) {
		HashSet<Character> set = new HashSet<Character>();
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			if (set.contains(s.charAt(i))) {
				set.remove(s.charAt(i));
				res += 2;
			} else
				set.add(s.charAt(i));
		}
		return set.isEmpty() ? res : res + 1;
	}
}
