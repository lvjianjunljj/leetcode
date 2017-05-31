package question.question300_399;

/*
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 * Example:
 * Given num = 16, return true. Given num = 5, return false.
 * Follow up: Could you solve it without loops/recursion?
 */
//既然不能用循环和迭代，那就只能用位运算了，而且还要用16进制的数。
public class Question342_others {
	public boolean isPowerOfFour(int num) {
		return num > 0 && (num & (num - 1)) == 0 && (num & (0x55555555)) != 0;
	}
}
