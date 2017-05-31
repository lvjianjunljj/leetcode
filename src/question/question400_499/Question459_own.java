package question.question400_499;

/*
 * Given a non-empty string check if it can be constructed by taking a substring of it 
 * and appending multiple copies of the substring together. 
 * You may assume the given string consists of lowercase English letters only and 
 * its length will not exceed 10000.
 * Example 1:
 * Input: "abab"
 * Output: True
 * Explanation: It's the substring "ab" twice.
 * Example 2:
 * Input: "aba"
 * Output: False
 */

//这种方法其实耗时还是比较低的，这道题本省还是非常容易的
public class Question459_own {
	public boolean repeatedSubstringPattern(String str) {
		int len = str.length();
		for (int i = 1; i < len; i++) {
			if (len % i > 0) {
				continue;
			}
			if (judge(str, i)) {
				return true;
			}
		}
		return false;
	}

	private boolean judge(String str, int len) {
		int count = str.length() / len;
		for (int i = 1; i < count; i++) {
			if (!str.substring(0, len).equals(
					str.substring(i * len, i * len + len))) {
				return false;
			}
		}
		return true;
	}
}
