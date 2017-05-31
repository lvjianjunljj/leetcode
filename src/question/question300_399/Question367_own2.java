package question.question300_399;

//用这种二分查找做，耗时能低一点
public class Question367_own2 {
	public boolean isPerfectSquare(int num) {
		return aux(num, 1, num);
	}

	private boolean aux(int num, long i, long j) {
		if (i > j)
			return false;
		long mid = (i + j) / 2;
		if (mid * mid == num)
			return true;
		else
			return mid * mid > num ? aux(num, i, mid - 1)
					: aux(num, mid + 1, j);
	}
}
