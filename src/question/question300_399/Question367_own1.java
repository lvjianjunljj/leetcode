package question.question300_399;

/*
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * Note: Do not use any built-in library function such as sqrt.
 * Example 1:
 * Input: 16
 * Returns: True
 * Example 2:
 * Input: 14
 * Returns: False
 */
//这道题真的一点意思都没有。。。
public class Question367_own1 {
	public boolean isPerfectSquare(int num) {
		// for (long i = 1; i * i <= num; i++)
		// if (i * i == num)
		// return true;
		// return false;
		long i = 1;
		while (i * i < num)
			i++;
		return i * i == num;

	}
}
