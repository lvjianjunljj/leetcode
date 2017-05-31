package question.question100_199;

/*
 * Reverse bits of a given 32 bits unsigned integer.
 * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), 
 * return 964176192 (represented in binary as 00111001011110000010100101000000).
 */
//对于将n看作是无符号的数，位运算>>>和<<<简直是好用，都不用自己判断
public class Question190_own {
	// you need treat n as an unsigned value
	public int reverseBits(int n) {
		long res = 0, i = 31;
		while (n != 0) {
			res += n % 2 != 0 ? Math.pow(2, i) : 0;
			n = n >>> 1;
			i--;
		}
		return (int) res;
	}
}
