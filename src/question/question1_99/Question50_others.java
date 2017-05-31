package question.question1_99;
//用递归来实现二分法（binary search），这才是最快的方法——就不应该让1递增至n，而是应该让n递减至0.
public class Question50_others {
	public double myPow(double x, int n) {
		double m = n;
		if (n == 0)
			return 1;
		if (m < 0) {
			m = -m;
			x = 1 / x;
		}
		return n % 2 == 0 ? myPow(x * x, (int) (m / 2)) : x
				* myPow(x, (int) (m - 1));
	}
}
