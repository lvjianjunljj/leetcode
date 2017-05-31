package question.question200_299;

/*
 * Given a pattern and a string str, find if str follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 Examples:
 pattern = "abba", str = "dog cat cat dog" should return true.
 pattern = "abba", str = "dog cat cat fish" should return false.
 pattern = "aaaa", str = "dog cat cat dog" should return false.
 pattern = "abba", str = "dog dog dog dog" should return false.
 */
//简单，没什么好说的
public class Question290_own {
	public boolean wordPattern(String pattern, String str) {
		char[] pat = pattern.toCharArray();
		String[] strs = str.split(" ");
		if (pat.length != strs.length)
			return false;
		for (int i = 0; i < pat.length; i++)
			for (int j = i + 1; j < pat.length; j++)
				if ((pat[i] == pat[j] && (!strs[i].equals(strs[j])) || (pat[i] != pat[j] && strs[i]
						.equals(strs[j]))))
					return false;
		return true;
	}
}
