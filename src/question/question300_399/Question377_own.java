package question.question300_399;

/*
 * Given an integer array with all positive numbers and no duplicates, 
 * find the number of possible combinations that add up to a positive integer target.
 * Example:
 * nums = [1, 2, 3]
 * target = 4
 * The possible combination ways are:
 (1, 1, 1, 1)
 (1, 1, 2)
 (1, 2, 1)
 (1, 3)
 (2, 1, 1)
 (2, 2)
 (3, 1)
 Note that different sequences are counted as different combinations.
 Therefore the output is 7.
 Follow up:
 What if negative numbers are allowed in the given array?
 How does it change the problem?
 What limitation we need to add to the question to allow negative numbers?
 */

//这道题不能用回溯做，肯定超时——只能用动态规划了
public class Question377_own {

	int count = 0;

	public int combinationSum4(int[] nums, int target) {
		dfs(nums, 0, target);
		return count;
	}

	private void dfs(int[] nums, int sum, int target) {
		if (sum > target)
			return;
		if (sum == target)
			count++;
		for (int i = 0; i < nums.length; i++) {
			dfs(nums, sum + nums[i], target);
		}
	}
}
