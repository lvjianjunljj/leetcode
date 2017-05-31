package question.question300_399;

/*
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * For example,
 * Given [10, 9, 2, 5, 3, 7, 101, 18],
 * The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 * Follow up: Could you improve it to O(n log n) time complexity?
 */
//常规动态规划，时间复杂度是On2，比较费时。
public class Question300_own {
	public int lengthOfLIS(int[] nums) {
		int n = nums.length, res = 0;
		if (n == 0)
			return 0;
		int[] sum = new int[n];
		for (int i = 0; i < n; i++) {
			sum[i] = 1;
			for (int j = 0; j < i; j++)
				if (nums[i] > nums[j])
					sum[i] = Math.max(sum[i], sum[j] + 1);
			res = Math.max(res, sum[i]);
		}
		return res;
	}
}
