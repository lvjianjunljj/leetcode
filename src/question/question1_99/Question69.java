package question.question1_99;

public class Question69 {
	public static void main(String[] args) {
		System.out.println(mySqrt(2147483647));
	}

	// 要小心x是int数据类型最大的数，那就会一直不能跳出第一个while循环
	public static int mySqrt(int x) {
		int i = 1;
		while (i * i < x && i * i > 0) {
			i += 100;
		}
		while (i * i > x || i * i < 0) {
			i--;
		}
		return i;
	}
}
