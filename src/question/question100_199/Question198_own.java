package question.question100_199;

/*
 * You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed, 
 * the only constraint stopping you from robbing each of them is that 
 * adjacent houses have security system connected and it will automatically contact the police 
 * if two adjacent houses were broken into on the same night.
 *  Given a list of non-negative integers representing the amount of money of each house, 
 *  determine the maximum amount of money you can rob tonight without alerting the police.
 */
//用动态规划做，很快
public class Question198_own {
	public int rob(int[] nums) {
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			nums[i] = nums[i] + Math.max(get(nums, i - 2), get(nums, i - 3));
			res = Math.max(res, nums[i]);
		}
		return res;
	}

	private int get(int[] nums, int index) {
		if (index < 0)
			return 0;
		return nums[index];
	}
}
