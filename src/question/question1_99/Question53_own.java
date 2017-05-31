package question.question1_99;

//非常简单，用贪心一做就出来了
public class Question53_own {
	public int maxSubArray(int[] nums) {
		int res = Integer.MIN_VALUE, cur = 0;
		for (int i : nums) {
			if (cur < 0) {
				cur = 0;
			}
			cur += i;
			if (cur > res) {
				res = cur;
			}
		}
		return res;
	}
}
