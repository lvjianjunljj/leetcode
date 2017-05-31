package question.question200_299;
//不管是主算法的设计还是aux算法的设计都在我之上，耗时低且空间复杂度为O1，既然是是否有环的判断，一定要想到用slow和fast，有的时候很管用
public class Question202_others {
	public boolean isHappy(int n) {
		int x = n, y = n;
		while (y > 1) {
			x = aux(x);
			y = aux(aux(y));
			if (x == 1)
				return true;
			if (x == y)
				return false;
		}
		return true;

	}

	public static int aux(int n) {
		int x = n;
		int s = 0;
		while (x > 0) {
			s = s + (x % 10) * (x % 10);
			x = x / 10;
		}
		return s;
	}
}
