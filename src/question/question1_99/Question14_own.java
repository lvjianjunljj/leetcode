package question.question1_99;
/*
 * Write a function to find the longest common prefix string amongst an array of strings.
 */

//没必要截断的，这样只会增加耗时
public class Question14_own {
	public String longestCommonPrefix(String[] strs) {
		String result = "";
		if (strs.length == 0) {
			return result;
		}
		while (!strs[0].equals("")) {
			String tran = strs[0].substring(0, 1);
			for (int i = 0; i < strs.length; i++) {
				if ((!strs[i].equals(""))
						&& strs[i].substring(0, 1).equals(tran)) {
					strs[i] = strs[i].substring(1);
				} else {
					return result;
				}
			}
			result = result + tran;
		}
		return result;
	}
}
