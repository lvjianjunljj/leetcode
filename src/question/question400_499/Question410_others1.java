package question.question400_499;

/*
 * Given an array which consists of non-negative integers and an integer m, 
 * you can split the array into m non-empty continuous subarrays. 
 * Write an algorithm to minimize the largest sum among these m subarrays.
 * Note:
 * Given m satisfies the following constraint: 1 ≤ m ≤ length(nums) ≤ 14,000.
 * Examples:
 * Input:
 * nums = [7,2,5,10,8]
 * m = 2
 * Output:
 * 18
 * Explanation:
 * There are four ways to split nums into two subarrays.
 * The best way is to split it into [7,2,5] and [10,8],
 * where the largest sum among the two subarrays is only 18.
 */

//其实这个想法还是非常巧妙的，dp维护的是以i为起始序列的分隔了s-1次的最小的max
public class Question410_others1 {
	public int splitArray(int[] nums, int m) {
		int len = nums.length;
		int[] sums = new int[len + 1];
		int[] dp = new int[len];
		for (int i = 0; i < len; i++) {
			sums[i + 1] = sums[i] + nums[i];
		}
		for (int i = 0; i < len; i++) {
			dp[i] = sums[len] - sums[i];
		}
		for (int s = 1; s < m; s++) {
			for (int i = 0; i < len - s; i++) {
				dp[i] = Integer.MAX_VALUE;
				for (int j = i + 1; j <= len - s; j++) {
					int t = Math.max(sums[j] - sums[i], dp[j]);
					if (dp[i] >= t)
						dp[i] = t;
					// 一旦跳入这个else就说明sums[j] - sums[i]大了，前面变得大了那就没必要再往后走了
					else
						break;
				}
			}
		}
		return dp[0];
	}
}
