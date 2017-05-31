package question.question200_299;

/*
 * After robbing those houses on that street,
 * the thief has found himself a new place for his thievery so that he will not get too much attention. 
 * This time, all houses at this place are arranged in a circle. 
 * That means the first house is the neighbor of the last one. Meanwhile, 
 * the security system for these houses remain the same as for those in the previous street.
 * Given a list of non-negative integers representing the amount of money of each house, 
 * determine the maximum amount of money you can rob tonight without alerting the police.
 */
//类比Question198，进行两遍（有无首个）就能得到答案。
public class Question213_own1 {
	public int rob(int[] nums) {
		if (nums.length == 0)
			return 0;
		int res = nums[0];
		int[][] sums = new int[2][nums.length];
		for (int i = 0; i < nums.length; i++) {
			sums[0][i] = nums[i];
			sums[1][i] = nums[i];
		}
		for (int i = 0; i < nums.length - 1; i++) {
			sums[0][i] = nums[i]
					+ Math.max(get(sums[0], i - 3), get(sums[0], i - 2));
			res = Math.max(res, sums[0][i]);
		}
		sums[1][0] = 0;
		for (int i = 1; i < nums.length; i++) {
			sums[1][i] = nums[i]
					+ Math.max(get(sums[1], i - 3), get(sums[1], i - 2));
			res = Math.max(res, sums[1][i]);
		}
		return res;
	}

	private static int get(int[] nums, int index) {
		if (index < 0)
			return 0;
		return nums[index];
	}
}
