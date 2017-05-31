package question.question200_299;
/*
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
 * For example, given the range [5, 7], you should return 4.
 */
//太他妈的机智了，通过位运算的左移和右移来实现，把二进制中靠后的不同的都置为0了
public class Question201_others {
	public int rangeBitwiseAnd(int m, int n) {
		if (m == 0) {
			return 0;
		}
		int moveFactor = 1;
		while (m != n) {
			m >>= 1;
			n >>= 1;
			moveFactor <<= 1;
		}
		return m * moveFactor;
	}
}
