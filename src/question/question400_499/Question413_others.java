package question.question400_499;

//这tm才是最简单的方法
public class Question413_others {
	public int numberOfArithmeticSlices(int[] A) {
		int res = 0, cur = 0;
		for (int i = 2; i < A.length; i++) {
			if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
				cur++;
				res += cur;
			} else {
				cur = 0;
			}
		}
		return res;
	}
}
