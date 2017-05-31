package question.question300_399;

/*
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * Examples:
 * s = "leetcode"
 * return 0.
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 */
//三个方法的耗时都在30ms左右——这种思路的方法细节上已经不能改变耗时了
public class Question387_own {
	public int firstUniqChar1(String s) {
		int[] sums = new int[26];
		for (int i = 0; i < s.length(); i++)
			sums[s.charAt(i) - 'a']++;
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < 26; i++)
			if (sums[i] == 1)
				res = Math.min(res, s.indexOf(((char) ('a' + i)) + ""));
		return res == Integer.MAX_VALUE ? -1 : res;
	}

	public int firstUniqChar2(String s) {
		int[] sums = new int[26];
		for (int i = 0; i < s.length(); i++)
			sums[s.charAt(i) - 'a']++;
		for (int i = 0; i < s.length(); i++)
			if (sums[s.charAt(i) - 'a'] == 1)
				return i;
		return -1;
	}

	public int firstUniqChar3(String s) {
		int[][] sums = new int[26][2];
		for (int i = 0; i < s.length(); i++) {
			sums[s.charAt(i) - 'a'][0]++;
			sums[s.charAt(i) - 'a'][1] = i;
		}
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < 26; i++)
			if (sums[i][0] == 1)
				res = Math.min(res, sums[i][1]);
		return res == Integer.MAX_VALUE ? -1 : res;
	}
}
