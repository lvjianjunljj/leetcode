package question.question1_99;

/*
 * Reverse digits of an integer.
 */
//转换成string去操作（太麻烦了）
public class Question07_own {
	public class Solution {
		public int reverse(int x) {
			int y = 0;
			if (x < 0) {
				if (x == Integer.MIN_VALUE) {
					return 0;
				} else {
					y = 0 - x;
				}
			} else {
				y = x;
			}
			String value = y + "";
			char[] list = value.toCharArray();
			char tran;
			for (int i = 0; i < list.length / 2; i++) {
				tran = list[i];
				list[i] = list[list.length - 1 - i];
				list[list.length - 1 - i] = tran;
			}
			value = "";
			for (char c : list) {
				value += c;
			}
			long resultLong = Long.valueOf(value);
			int result = 0;
			if (resultLong > Integer.MAX_VALUE) {
				return 0;
			} else {
				result = (int) resultLong;
			}
			if (x < 0) {
				result = 0 - result;
			}
			return result;
		}
	}
}
