package question.question100_199;
/*
 * Given an integer n, return the number of trailing zeroes in n!.
 */
//对于这种数学问题我也是无能为力了。
/*
 * 分解因子, 当且仅当 因子中出现 一对 (2,5)时, 最后结果会增加一个 trailing zero.
 * 2的个数永远多于5个个数.
 * 计算5的个数时, 最简单的方法是 SUM(N/5^1,  N/5^2, N/5^3...)
 */
public class Question172_others {
	public int trailingZeroes(int n) {
		int r = 0;
		while (n > 0) {
			n /= 5;
			r += n;
		}
		return r;
	}
}
