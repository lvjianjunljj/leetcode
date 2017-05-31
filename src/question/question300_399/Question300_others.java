package question.question300_399;

import java.util.Arrays;
//用binarySearch实现时间复杂度为Onlgn，简直是机智，我想不到——用dp存的是递增数组，而不是结果。
public class Question300_others {
	public int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
		int len = 0;
		for (int i : nums) {
			int j = Arrays.binarySearch(dp, 0, len, i);
			if (j < 0) {
				j = -(j + 1);
				dp[j] = i;
			}
			if (j == len)
				len++;
		}
		return len;
	}
}
a