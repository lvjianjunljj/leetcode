package question.question300_399;

/*
 * There is a list of sorted integers from 1 to n. Starting from left to right, 
 * remove the first number and every other number afterward until you reach the end of the list.
 * Repeat the previous step again, but this time from right to left, remove the right most number 
 * and every other number from the remaining numbers.
 * We keep repeating the steps again, alternating left to right and right to left, until a single number remains.
 * Find the last number that remains starting with a list of length n.
 * Example:
 * Input:
 * n = 9,
 * 1 2 3 4 5 6 7 8 9
 * 2 4 6 8
 * 2 6
 * 6
 * Output:
 * 6
 */

//这道题的思路还是非常清晰的，就是分正反两个方向，每次都是剔除一半的数，用递归去做就能出来了，只是反方向的时候要判断一下
//注意只返回结果就行，没必要建立数组
public class Question390_own {
	public int lastRemaining(int n) {
		return aux(n, true);
	}

	private int aux(int n, boolean toRight) {
		if (n == 1)
			return 1;
		if (toRight)
			return 2 * aux(n / 2, false);
		else if (n % 2 == 0)
			return 2 * aux(n / 2, true) - 1;
		else
			return 2 * aux(n / 2, true);
	}
}
