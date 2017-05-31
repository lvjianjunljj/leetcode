package algorithm;

import java.util.HashMap;

/*
 * KMP算法确实非常棒，特别是j = next[j];这一步一定要理解好了
 */
public class Kmp {
	public static void main(String[] args) {
		String s = "bcabcacabbabcbabcabcaabcabcabcacabc"; // 主串
		String t = "abcabcacab"; // 模式串
		char[] ss = s.toCharArray();
		char[] tt = t.toCharArray();
		System.out.println(KMP_Index(ss, tt)); // KMP匹配字符串
	}

	/**
	 * 获得字符串的next函数值
	 * 
	 * @param t字符串
	 * @return next函数值
	 */
	public static int[] next(char[] t) {
		int[] next = new int[t.length];
		next[0] = -1;
		int i = 0, j = -1;
		while (i < next.length - 1) {
			if (j == -1 || t[i] == t[j]) {
				i++;
				j++;
				if (t[i] == t[j])
					next[i] = next[j];
				else
					next[i] = j;
			} else
				j = next[j];
		}

		for (int k : next)
			System.out.println(k);
		return next;
	}

	/**
	 * KMP匹配字符串
	 * 
	 * @param s
	 *            主串
	 * @param t
	 *            模式串
	 * @return 若匹配成功，返回下标，否则返回-1
	 */
	public static int KMP_Index(char[] s, char[] t) {
		int[] next = next(t);
		int i = 0, j = 0;
		while (i < s.length && j < t.length) {
			if (j == -1 || s[i] == t[j]) {
				i++;
				j++;
			} else
				j = next[j];
		}
		if (j < t.length)
			return -1;
		return i - t.length;
	}
}
