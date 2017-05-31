package question.question300_399;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//虽然麻烦了一点，但是这道题用HashMap确实是能做的
//主流应该就是这两种思路了
public class Question336_others2 {
	public List<List<Integer>> palindromePairs(String[] words) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < words.length; i++)
			map.put(words[i], i);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for (int i = 0; i < words.length; i++) {
			int l = 0, r = 0;
			while (l <= r) {
				Integer j = map.get(new StringBuilder(words[i].substring(l, r))
						.reverse().toString());
				if (j != null
						&& i != j
						&& isPalindrome(words[i], l == 0 ? r : 0,
								l == 0 ? words[i].length() - 1 : l - 1))
					res.add(Arrays.asList(l == 0 ? i : j, l == 0 ? j : i));
				if (r < words[i].length())
					r++;
				else
					l++;
			}
		}
		return res;
	}

	private boolean isPalindrome(String s, int i, int j) {
		while (i < j) {
			if (s.charAt(i++) != s.charAt(j--))
				return false;
		}
		return true;
	}
}
