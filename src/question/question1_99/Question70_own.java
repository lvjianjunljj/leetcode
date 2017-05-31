package question.question1_99;

/*
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
//想通了就是斐波那契数列，动态规划瞬间就出来了。
public class Question70_own {
	public int climbStairs(int n) {
		int[] num = new int[n];
		num[0] = 1;
		if (n == 1) {
			return 1;
		}
		num[1] = 2;
		for (int i = 2; i < n; i++) {
			num[i] = num[i - 1] + num[i - 2];
		}
		return num[n - 1];
	}
}
