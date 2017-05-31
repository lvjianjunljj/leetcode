package question.question1_99;

/*
 * Implement pow(x, n).
 */

//用二分法做，可是耗时还是很高——这个方法的时间复杂度并不是Olgn而是On。
public class Question50_own {
	public double myPow(double x, int n) {
		if (n == 0)
			return 1;
		double m = n;
		if (n < 0)
			m = -m;
		double res = x;
		double i = 1;
		while (i < m) {
			res = res * res;
			i *= 2;
		}
		while (i > m) {
			res = res / x;
			i--;
		}
		return n > 0 ? res : 1 / res;
	}
}
