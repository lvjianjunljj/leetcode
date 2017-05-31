package question.question1_99;

//完全没有必要耗费空间复杂度
public class Question70_own2 {
	public int climbStairs(int n) {
		int a = 1, b = 1;
		for (int i = 1; i < n; i++) {
			b += a;
			a = b - a;
		}
		return b;
	}
}
