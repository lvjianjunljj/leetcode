package question.question1_99;

/*
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 */
//没什么意思，就是一直从后向前遍历直到某一位不是9，都是9的话就是返回一个{ 1, 0, 0, 0, 0, 0 ...}的数组
public class Question66_own {
	public int[] plusOne(int[] digits) {
		int n = digits.length - 1;
		while (n >= 0) {
			if (digits[n] != 9)
				break;
			else {
				digits[n] = 0;
				n--;
			}
		}
		if (n >= 0) {
			digits[n]++;
			return digits;
		} else {
			int[] res = new int[digits.length + 1];
			res[0] = 1;
			return res;
		}
	}
}
