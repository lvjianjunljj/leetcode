package question.question200_299;
/*
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * For example:
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 */
//数学方法，没什么意思（两个写法是一个意思）——2ms
public class Question258_own1 {
	public int addDigits1(int num) {
		return num % 9 == 0 ? (num == 0 ? 0 : 9) : num % 9;
	}
	public int addDigits2(int num) {
		if (num == 0)
			return 0;
		return num % 9 == 0 ? 9 : num % 9;
	}
}
