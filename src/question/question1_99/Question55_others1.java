package question.question1_99;

//网上给的答案，简单易懂，耗时还短，简直牛逼
public class Question55_others1 {
	public boolean canJump(int[] A) {
		int max = 0;
		for (int i = 0; i < A.length; i++) {
			if (i > max)
				return false;
			max = Math.max(A[i] + i, max);
		}
		return true;
	}
}
