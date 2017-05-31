package question.question1_99;

//用二分法才是正确的思路，之前那是什么鬼方法啊
public class Question69_own {
	public int mySqrt(int x) {
		int start = 1, end = 64000;
		while (start <= end) {
			int mid = (start + end) / 2;
			int tmp = mid * mid;
			if (tmp == x) {
				return mid;
			} else if (tmp > x || tmp < 0) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return end;
	}
}
