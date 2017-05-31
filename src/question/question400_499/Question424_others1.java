package question.question400_499;
/*
 * Given a string that consists of only uppercase English letters, 
 * you can replace any letter in the string with another letter at most k times. 
 * Find the length of a longest substring containing all repeating letters 
 * you can get after performing the above operations.
 * Note:
 * Both the string's length and k will not exceed 104.
 * Example 1:
 * Input:
 * s = "ABAB", k = 2
 * Output:
 * 4
 * Explanation:
 * Replace the two 'A's with two 'B's or vice versa.
 * Example 2:
 * Input:
 * s = "AABABBA", k = 1
 * Output:
 * 4
 * Explanation:
 * Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 */

//Sliding Window方法，维护好start和end两个参数之后，其中的参数要能想到怎么去进行维护
public class Question424_others1 {
	public int characterReplacement(String s, int k) {
		int start = 0, max = 0, res = 0;
		int[] count = new int[26];
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i) - 'A']++;
			if (max < count[s.charAt(i) - 'A']) {
				max = count[s.charAt(i) - 'A'];
			}
			while (i - start - max + 1 > k) {
				count[s.charAt(start) - 'A']--;
				start++;
				for (int j = 0; j < count.length; j++) {
					if (max < count[j]) {
						max = count[j];
					}
				}
			}
			if (res < i - start + 1) {
				res = i - start + 1;
			}
		}
		return res;
	}
}
