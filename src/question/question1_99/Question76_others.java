package question.question1_99;

/*
 * Given a string S and a string T, find the minimum window in S which will contain all the characters 
 * in T in complexity O(n).
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window 
 * in S.
 */

//这绝对是这道题最简练的方法，维护一个128位的数组表示t中每一位在s中出现的次数——简直是美妙
//其他方法思想相同但够简练，老子就不写了
public class Question76_others {
	public String minWindow(String s, String t) {
		int[] list = new int[128];
		for (char c : t.toCharArray())
			list[c]++;
		int start = 0, begin = 0, end = 0, d = Integer.MAX_VALUE, count = t
				.length();
		while (end < s.length()) {
			if (list[s.charAt(end++)]-- > 0)
				count--;
			while (count == 0) {
				if (end - begin < d)
					d = end - (start = begin);
				if (list[s.charAt(begin++)]++ == 0)
					count++;
			}
		}
		return d == Integer.MAX_VALUE ? "" : s.substring(start, start + d);
	}
}
