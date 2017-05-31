package question.question1_99;

//数字的反转完全不需要将其转换成string就可以做，通过除10和对10取余就能做
public class Question07_others {
	public int reverse(int x) {
		long res = 0;
		while (x != 0) {
			res = res * 10 + x % 10;
			x = x / 10;
			if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
				return 0;
			}
		}
		return (int) res;
	}
}
