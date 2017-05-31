package question.question400_499;
/*
 * Given a non-empty string containing an out-of-order English representation of digits 0-9, 
 * output the digits in ascending order.
 * Note:
 * Input contains only lowercase English letters.
 * Input is guaranteed to be valid and can be transformed to its original digits. 
 * That means invalid inputs such as "abc" or "zerone" are not permitted.
 * Input length is less than 50,000.
 * Example 1:
 * Input: "owoztneoer"
 * Output: "012"
 * Example 2:
 * Input: "fviefuro"
 * Output: "45"
 */

//0到9每个对应的word其实都有自己对应的char（先将有的剔除掉就都能找到对应的char）
public class Question423_own1 {
	public String originalDigits(String s) {
		int[] count = new int[26];
		int[] res = new int[10];
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i) - 'a']++;
		}
		res[0] = count['z' - 'a'];
		count['e' - 'a'] -= res[0];
		count['r' - 'a'] -= res[0];
		count['o' - 'a'] -= res[0];
		res[2] = count['w' - 'a'];
		count['t' - 'a'] -= res[2];
		count['o' - 'a'] -= res[2];
		res[8] = count['g' - 'a'];
		count['e' - 'a'] -= res[8];
		count['i' - 'a'] -= res[8];
		count['h' - 'a'] -= res[8];
		count['t' - 'a'] -= res[8];
		res[6] = count['x' - 'a'];
		count['s' - 'a'] -= res[6];
		count['i' - 'a'] -= res[6];
		res[4] = count['u' - 'a'];
		count['f' - 'a'] -= res[4];
		count['o' - 'a'] -= res[4];
		count['r' - 'a'] -= res[4];
		res[3] = count['h' - 'a'];
		count['t' - 'a'] -= res[3];
		count['r' - 'a'] -= res[3];
		count['e' - 'a'] -= res[3];
		count['e' - 'a'] -= res[3];
		res[5] = count['f' - 'a'];
		count['i' - 'a'] -= res[5];
		count['v' - 'a'] -= res[5];
		count['e' - 'a'] -= res[5];
		res[7] = count['s' - 'a'];
		count['e' - 'a'] -= res[7];
		count['v' - 'a'] -= res[7];
		count['e' - 'a'] -= res[7];
		count['n' - 'a'] -= res[7];
		res[9] = count['i' - 'a'];
		count['n' - 'a'] -= res[9];
		count['n' - 'a'] -= res[9];
		count['e' - 'a'] -= res[9];
		res[1] = count['o' - 'a'];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[i]; j++) {
				sb.append(i);
			}
		}
		return sb.toString();
	}
}
