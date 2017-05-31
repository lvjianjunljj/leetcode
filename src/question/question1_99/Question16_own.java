package question.question1_99;
/*
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
//简直是不想用这个方法，和没写一样
public class Question16_own {
	public int threeSumClosest(int[] nums, int target) {
		int dif = Integer.MAX_VALUE;
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					if (nums[i] + nums[j] + nums[k] - target == 0)
						return target;
					if (dif > Math.abs(nums[i] + nums[j] + nums[k] - target)) {
						dif = Math.abs(nums[i] + nums[j] + nums[k] - target);
						res = nums[i] + nums[j] + nums[k];
					}
				}
			}
		}
		return res;
	}
}
