package question.question300_399;

/*
 * Write a program to find the nth super ugly number.
 * Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k. 
 * For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super 
 * ugly numbers given primes = [2, 7, 13, 19] of size 4.
 */
//封装了一个index数组，用于存储下个数是primes[j] * ugly[index[j]，确实巧妙
public class Question313_others1 {
	public int nthSuperUglyNumber(int n, int[] primes) {
		int[] ugly = new int[n];
		ugly[0] = 1;
		int[] factor = new int[primes.length];
		int[] index = new int[primes.length];
		for (int i = 0; i < primes.length; i++)
			factor[i] = primes[i];
		for (int i = 1; i < n; i++) {
			int element = Integer.MAX_VALUE;
			for (int j : factor)
				element = Math.min(element, j);
			ugly[i] = element;
			//最巧妙的就是这个循环了
			for (int j = 0; j < primes.length; j++)
				if (factor[j] == element)
					factor[j] = primes[j] * ugly[++index[j]];
		}
		return ugly[n - 1];
	}
}
