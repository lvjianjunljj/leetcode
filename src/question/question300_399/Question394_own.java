package question.question300_399;

/*
 * Given an encoded string, return it's decoded string.
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated 
 * exactly k times. Note that k is guaranteed to be a positive integer.
 * You may assume that the input string is always valid; No extra white spaces, 
 * square brackets are well-formed, etc.
 * Furthermore, you may assume that the original data does not contain any digits 
 * and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 * Examples:
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */

//先找到第一个']'这就对应着最内部的一组重复字符串，由内向外解码，递归很好实现
//这个题其实就和385很像了（但是远比385简单）——stack也能做
public class Question394_own {
	public String decodeString(String s) {
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ']') {
				int start = searchLetter(s, i);
				String tmp = s.substring(start + 1, i);
				int prev = searchNum(s, start);
				int num = Integer.parseInt(s.substring(prev, start));
				res.append(s.substring(0, prev));
				for (int j = 0; j < num; j++)
					res.append(tmp);
				res.append(s.substring(i + 1));
				return decodeString(res.toString());
			}
		}

		return s;
	}

	private int searchLetter(String s, int i) {
		for (int j = i - 1; j >= 0; j--)
			if (s.charAt(j) == '[')
				return j;
		return -1;
	}

	private int searchNum(String s, int i) {
		for (int j = i - 1; j >= 0; j--)
			if (s.charAt(j) > '9' || s.charAt(j) < '0')
				return j + 1;
		return 0;
	}
}
