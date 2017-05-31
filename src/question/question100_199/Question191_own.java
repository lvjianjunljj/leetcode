package question.question100_199;

/*
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).
 * For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 */
//自己写了一个将int转成无符号的long的方法，也没谁了，耗时还不是很高~~~
public class Question191_own {
	public int hammingWeight(int n) {
		long k = noSymbol(n);
		int sum = 0;
		while (k > 0) {
			System.out.println(k);
			sum += k % 2;
			k = k / 2;
		}
		return sum;
	}

	private long noSymbol(int n) {
		if (n < 0) {
			return (long) (Integer.MAX_VALUE) + Integer.MAX_VALUE + 2 + n;
		}
		return n;
	}
}
