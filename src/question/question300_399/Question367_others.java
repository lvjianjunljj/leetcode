package question.question300_399;

//数学方法——1+3+5+7+。。。得到的肯定是一个个平方数。
public class Question367_others {
	public boolean isPerfectSquare(int num) {
		int i = 1;
		while (num > 0) {
			num -= i;
			i += 2;
		}
		return num == 0;
	}
}
