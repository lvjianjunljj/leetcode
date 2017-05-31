package question.question300_399;

//这个方法也没有机智太多，就是对于向左和n % 2 == 1两种情况其对应的数值才会变
//然后维护一个step参数表示剩余数字两两之间的间隔，简单
public class Question390_others {
	public int lastRemaining(int n) {
		boolean left = true;
		int res = 1, step = 1;
		while (n > 1) {
			if (left || n % 2 == 1)
				res += step;
			n /= 2;
			step *= 2;
			left = !left;
		}
		return res;
	}
}
