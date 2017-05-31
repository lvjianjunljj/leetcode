package question.question300_399;
/*
 * Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.
 * For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
 */
//用数学方法做，找到3这个数字
public class Question343_own1 {
	public int integerBreak(int n) {
		int res = 1;
		if (n < 3)
			return res;
		if (n == 3)
			return 2;
		while (n > 4) {
			res *= 3;
			n -= 3;
		}
		return res * n;
	}
}
