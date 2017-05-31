package question.question200_299;

import java.util.HashMap;

//其实用HashMap的containsValue方法可以避免建两个HashMap
public class Question205_others2 {
	public boolean isIsomorphic(String s, String t) {
		if (s == null || s.length() <= 1)
			return true;
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		for (int i = 0; i < s.length(); i++) {
			char a = s.charAt(i);
			char b = t.charAt(i);
			if (map.containsKey(a)) {
				if (map.get(a).equals(b))
					continue;
				else
					return false;
			} else {
				if (!map.containsValue(b))
					map.put(a, b);
				else
					return false;

			}
		}
		return true;
	}
}
