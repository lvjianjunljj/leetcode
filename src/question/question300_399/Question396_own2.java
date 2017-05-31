package question.question300_399;

//只要细心一想就能想到这种办法，每一个对应位置的数都加一次，然后对应乘数最多的数减去n次，就变成了其下一个对应的和
//把表达式一写出来就明白了
public class Question396_own2 {
	public int maxRotateFunction(int[] A) {
		int sum = 0, tmp = 0, res = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
			tmp += i * A[i];
		}
		res = tmp;
		for (int i = A.length - 1; i > 0; i--) {
			tmp += sum - A[i] * A.length;
			res = Math.max(res, tmp);
		}
		return res;
	}
}
