package question.question400_499;

//这种带备忘录的动态规划就在回溯上直接修改就能出来——我还是太菜
public class Question416_others2 {
	public boolean canPartition(int[] nums) {
		int sum = 0;
		for (int i : nums) {
			sum += i;
		}
		if (sum % 2 == 1) {
			return false;
		}
		sum /= 2;
		int[][] dp = new int[nums.length][sum + 1];
		return dfs(nums, dp, 0, 0);
	}

	private boolean dfs(int[] nums, int[][] dp, int i, int j) {
		if (i >= dp.length || j >= dp[0].length) {
			return false;
		}
		if (j == dp[0].length - 1) {
			return true;
		}
		if (dp[i][j] > 0) {
			return dp[i][j] == 1;
		}
		boolean res = dfs(nums, dp, i + 1, j + nums[i])
				|| dfs(nums, dp, i + 1, j);
		dp[i][j] = res ? 1 : 2;
		return res;
	}
}
