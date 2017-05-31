package question.question400_499;
/*
 * Given a non-empty array containing only positive integers, 
 * find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 * Note:
 * Each of the array element will not exceed 100.
 * The array size will not exceed 200.
 * Example 1:
 * Input: [1, 5, 11, 5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * Example 2:
 * Input: [1, 2, 3, 5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 */

//用回溯做果然还是会超时的
public class Question416_own {
	public boolean canPartition(int[] nums) {
		int sum = 0;
		for (int i : nums) {
			sum += i;
		}
		if (sum % 2 == 1) {
			return false;
		}
		sum = sum / 2;
		boolean[] visit = new boolean[nums.length];
		return dfs(nums, visit, 0, sum);
	}

	private boolean dfs(int[] nums, boolean[] visit, int cur, int sum) {
		if (cur > sum) {
			return false;
		} else if (cur == sum) {
			return true;
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (!visit[i]) {
					visit[i] = true;
					if (dfs(nums, visit, cur + nums[i], sum)) {
						return true;
					}
					visit[i] = false;
				}
			}
			return false;
		}
	}
}
