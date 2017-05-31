package question.question1_99;
//这种写法才是最简洁明了且耗时最低的
public class Question66_others {
	public int[] plusOne(int[] digits) {
		int n = digits.length - 1;
		while (n >= 0) {
			if (digits[n] != 9) {
				digits[n]++;
				return digits;
			}
			digits[n--] = 0;
		}
		int[] res = new int[digits.length + 1];
		res[0] = 1;
		return res;
	}
}
