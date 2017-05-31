package question.question300_399;

/*
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 * Example:
 * Given a = 1 and b = 2, return 3.
 */
import java.util.Stack;
//一个负数的二进制表示是其对应正数的二进制的反码加一，所以用二进制数去加一个负数其实也就是减其对应整数——
//在底层计算的时候都是用二进制运算的——其实二进制的加法和我在这里写的也就差不多了
public class Question371_own {
	public int getSum(int a, int b) {
		int c = 0, res = 0;
		Stack<Boolean> stack = new Stack<Boolean>();
		while (a != 0 || b != 0 || c != 0) {
			int aEnd = a & 1;
			int bEnd = b & 1;
			stack.add((aEnd ^ bEnd ^ c) == 1);
			c = (aEnd == 1 && bEnd == 1) || (aEnd == 1 && c == 1)
					|| (c == 1 && bEnd == 1) ? 1 : 0;
			a >>>= 1;
			b >>>= 1;
		}
		while (!stack.isEmpty()) {
			res <<= 1;
			if (stack.pop())
				res ^= 1;
		}
		return res;
	}
}
