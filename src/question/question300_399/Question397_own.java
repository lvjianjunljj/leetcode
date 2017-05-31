package question.question300_399;

/*
 * Given a positive integer n and you can do operations as follow:
 * If n is even, replace n with n/2.
 * If n is odd, you can replace n with either n + 1 or n - 1.
 * What is the minimum number of replacements needed for n to become 1?
 * Example 1:
 * Input:
 * 8
 * Output:
 * 3
 * Explanation:
 * 8 -> 4 -> 2 -> 1
 * Example 2:
 * Input:
 * 7
 * Output:
 * 4
 * Explanation:
 * 7 -> 8 -> 4 -> 2 -> 1
 * or
 * 7 -> 6 -> 3 -> 2 -> 1
 */

//这道题这种解法的思路本身很简单，但是这道题的分类是Math，所以我以为这种暴力破解的方法会超时——然而没有
public class Question397_own {
	public int integerReplacement(int n) {
		return aux(n, 0);
	}

	private int aux(long num, int step) {
		if (num == 1)
			return step;
		if (num % 2 == 0)
			return aux(num / 2, step + 1);
		return Math.min(aux(num + 1, step + 1), aux(num - 1, step + 1));
	}
}
