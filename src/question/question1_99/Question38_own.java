package question.question1_99;
/*
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 */
//根据题意思路就有了，并不难
public class Question38_own {
	public String countAndSay(int n) {
		String[] strs = new String[n];
		strs[0] = "1";
		for (int i = 1; i < n; i++)
			strs[i] = aux(strs[i - 1]);
		return strs[n - 1];
	}

	public static String aux(String str) {
		String res = "";
		char[] array = str.toCharArray();
		int n = 1, len = array.length;
		for (int i = 1; i < len; i++) {
			if (array[i] == array[i - 1])
				n++;
			else {
				res += (n + "" + (array[i - 1] - '0'));
				n = 1;
			}
		}
		return res + (n + "" + (array[len - 1] - '0'));
	}
}
