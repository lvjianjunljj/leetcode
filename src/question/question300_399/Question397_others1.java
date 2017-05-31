package question.question300_399;

//每一步的计算都是为了能让其二进制数的1更少
//注意奇数时加一减一相等的情况应该令n加一（比如二进制数1011111011的情况，加一优于减一）
public class Question397_others1 {
	public int integerReplacement(int n) {
		int res = 0;
		while (n != 1) {
			if (n % 2 == 0)
				n >>>= 1;
			else if (n == 3
					|| Integer.bitCount(n + 1) > Integer.bitCount(n - 1))
				n--;
			else
				n++;
			res++;
		}
		return res;
	}
}
