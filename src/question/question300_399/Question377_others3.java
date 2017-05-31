package question.question300_399;

import java.util.Arrays;

//这种带备忘录的动态规划以前最常写了，现在忘得差不多了啊
public class Question377_others3 {
	public int combinationSum4(int[] nums, int target) {
		int[] dp = new int[target + 1];
		Arrays.fill(dp, -1);
		dp[0] = 1;
		return aux(dp, nums, target);
	}

	private int aux(int[] dp, int[] nums, int target) {
		if (dp[target] >= 0)
			return dp[target];
		dp[target] = 0;
		for (int i : nums)
			if (i <= target)
				dp[target] += aux(dp, nums, target - i);
		return dp[target];
	}
}
