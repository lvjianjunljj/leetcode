package question.question300_399;

/*
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.
 * Example 1:
 * Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
 * Return 16
 * The two words can be "abcw", "xtfn".
 * Example 2:
 * Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
 * Return 4
 * The two words can be "ab", "cd".
 * Example 3:
 * Given ["a", "aa", "aaa", "aaaa"]
 * Return 0
 * No such pair of words.
 */
import java.util.HashSet;
//主方法的双层for循环没有办法简化，只能优化notCommon方法，我用HAshSet，boolean[]和位运算都不能很好的降低耗时
public class Question318_own {
	public int maxProduct(String[] words) {
		int res = 0;
		for (int i = 0; i < words.length; i++)
			for (int j = i + 1; j < words.length; j++)
				if (res < words[i].length() * words[j].length()
						&& notCommon2(words[i], words[j]))
					res = words[i].length() * words[j].length();
		return res;
	}

	private boolean notCommon1(String word1, String word2) {
		boolean[] list1 = new boolean[26];
		boolean[] list2 = new boolean[26];
		for (int i = 0; i < word1.length(); i++)
			list1[word1.charAt(i) - 'a'] = true;
		for (int i = 0; i < word2.length(); i++)
			list2[word2.charAt(i) - 'a'] = true;
		for (int i = 0; i < 26; i++)
			if (list1[i] && list2[i])
				return false;
		return true;

	}

	private boolean notCommon2(String word1, String word2) {
		HashSet<Character> set = new HashSet<Character>();
		for (int i = 0; i < word1.length(); i++)
			set.add(word1.charAt(i));
		for (int i = 0; i < word2.length(); i++)
			if (set.contains(word2.charAt(i)))
				return false;
		return true;
	}

	private boolean notCommon3(String word1, String word2) {
		int num1 = 0, num2 = 0;
		for (int i = 0; i < word1.length(); i++)
			num1 |= (1 << (word1.charAt(i)) - 'a');
		for (int i = 0; i < word2.length(); i++)
			num2 |= (1 << (word2.charAt(i)) - 'a');
		return (num1 & num2) == 0;
	}
}
