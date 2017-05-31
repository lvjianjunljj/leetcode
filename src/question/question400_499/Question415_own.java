package question.question400_499;

/*
 * Given two non-negative numbers num1 and num2 represented as string, return the sum of num1 and num2.
 * Note:
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */

//没什么意思，很快就出来了
public class Question415_own {
	public String addStrings(String num1, String num2) {
		if (num1.length() < num2.length())
			return addStrings(num2, num1);
		String res = "";
		int index = num2.length() - 1, carry = 0;
		for (int i = num1.length() - 1; i >= 0; i--) {
			int sum = num1.charAt(i)
					+ (index >= 0 ? num2.charAt(index--) : '0') - '0' * 2
					+ carry;
			res = sum % 10 + res;
			carry = sum / 10;
		}
		if (carry > 0)
			res = '1' + res;
		return res;
	}
}
