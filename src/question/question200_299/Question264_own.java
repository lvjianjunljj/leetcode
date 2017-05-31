package question.question200_299;
/*
 * Write a program to find the n-th ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note that 1 is typically treated as an ugly number.
 */
//思路和313完全是一样的
public class Question264_own {
	public int nthUglyNumber(int n) {
		int[] factor = { 2, 3, 5 };
		int[] primes = { 2, 3, 5 };
		int[] index = { 1, 1, 1 };
		int[] ugly = new int[n];
		ugly[0] = 1;
		for (int i = 1; i < n; i++) {
			int element = Integer.MAX_VALUE;
			for (int j : factor)
				element = Math.min(element, j);
			ugly[i] = element;
			for (int j = 0; j < 3; j++)
				if (factor[j] == element)
					factor[j] = primes[j] * ugly[index[j]++];
		}
		return ugly[n - 1];
	}
}
