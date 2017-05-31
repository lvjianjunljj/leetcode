package question.question1_99;
/*
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 */
//用数学方法去做，就是有m-1个红球和n-1个白球排序（排列组合嘛，很简单）
public class Question62_own {
	public int uniquePaths(int m, int n) {
		if (m < 2 || n < 2)
			return 1;
		double up = m;
		double down = 1;
		for (int i = 1; i < n - 1; i++) {
			up *= (m + i);
			down *= (i + 1);
		}
		return (int) (up / down);
	}
}
