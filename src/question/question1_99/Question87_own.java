package question.question1_99;

/*
 * Given a string s1, we may represent it as a binary tree by partitioning it 
 * to two non-empty substrings recursively.
 * Below is one possible representation of s1 = "great":

 great
 /    \
 gr    eat
 / \    /  \
 g   r  e   at
 / \
 a   t
 To scramble the string, we may choose any non-leaf node and swap its two children.
 For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

 rgeat
 /    \
 rg    eat
 / \    /  \
 r   g  e   at
 / \
 a   t
 We say that "rgeat" is a scrambled string of "great".
 Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

 rgtae
 /    \
 rg    tae
 / \    /  \
 r   g  ta  e
 / \
 t   a
 We say that "rgtae" is a scrambled string of "great".
 Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 */

//我能想到的最优的方法了——但是确实耗时长了一些，超时了——用递归遍历每一种情况——这个题可能只能用动态规划做了
//根据others1的想法对方法进行改进了还是超时了——其实我的想法和others1的想法是一样的，只是封装的不好
public class Question87_own {
	public boolean isScramble(String s1, String s2) {
		char[] list1 = s1.toCharArray();
		char[] list2 = s2.toCharArray();
		if (list1.length != list2.length)
			return false;
		return dfs(list1, list2, 0, list1.length, 0, list2.length);
	}

	private boolean dfs(char[] list1, char[] list2, int i, int j, int m, int n) {
		if (judge(list1, list2, i, j, m, n))
			return true;
		int[] tmp = new int[26];
		for (int k = i; k < j; k++) {
			tmp[list1[k] - 'a']++;
			tmp[list2[m - i + k] - 'a']--;
		}
		for (int k = i; k < j; k++)
			if (tmp[k] != 0)
				return false;
		for (int k = i + 1; k < j; k++) {
			if ((dfs(list1, list2, i, k, m, m + k - i) && dfs(list1, list2, k,
					j, m + k - i, n))
					|| (dfs(list1, list2, i, k, n + i - k, n) && dfs(list1,
							list2, k, j, m, m + j - k)))
				return true;
		}
		return false;
	}

	private boolean judge(char[] list1, char[] list2, int i, int j, int m, int n) {
		for (int k = i; k < j; k++)
			if (list1[k] != list2[k + m - i])
				return false;
		return true;
	}
}
