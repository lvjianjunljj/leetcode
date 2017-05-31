package question.question1_99;

import java.util.ArrayList;
/*
 * Given a string, find the length of the longest substring without repeating characters.
 */
// 用动态规划做不行，分左右和中间，中间的情况不好求得最大值
public class Question03_own1 {
	public int lengthOfLongestSubstring(String s) {
		int result = 0;
		int k = 0;
		int n = s.length();
		char[] list = s.toCharArray();
		ArrayList<Character> array = new ArrayList<Character>();
		for (int i = 0; i < n; i++) {
			if (array.indexOf(list[i]) != -1) {
				k = array.indexOf(list[i]);
				for (int j = 0; j < k + 1; j++) {
					array.remove(0);
				}
				array.add(list[i]);
			} else {
				array.add(list[i]);
				if (result < array.size()) {
					result = array.size();
				}
			}
		}
		return result;
	}
}
