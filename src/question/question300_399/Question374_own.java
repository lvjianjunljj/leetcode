package question.question300_399;

/*
 * We are playing the Guess Game. The game is as follows:
 * I pick a number from 1 to n. You have to guess which number I picked.
 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 * -1 : My number is lower
 * 1 : My number is higher
 * 0 : Congrats! You got it!
 * Example:
 * n = 10, I pick 6.
 * Return 6.
 */

//用二分法做，非常简单
public class Question374_own {
	int max = Integer.MAX_VALUE;
	int min = 1;

	public int guessNumber(int n) {
		if (guess(n) == 0)
			return n;
		else if (guess(n) < 0)
			max = n - 1;
		else
			min = n + 1;
		return guessNumber(min + (max - min) / 2);
	}

	private int guess(int n) {
		if (n == 16)
			return 0;
		return n > 15 ? 1 : -1;
	}
}
