package question.question100_199;

/*
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 */
//自己并不是用动态规划做的，所以耗时长一点。（我看了网上的答案，大家都是这种思路，没意思）
public class Question152_own {
	public int maxProduct(int[] nums) {
		int result = nums[0];
		int maxCur = 0, minCur = 0;
		int max = nums[0];
		int min = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == 0) {
				max = 1;
				min = 1;
				result = Math.max(result, 0);
			} else {
				maxCur = Math.max(Math.max(min * nums[i], max * nums[i]),
						nums[i]);
				minCur = Math.min(Math.min(min * nums[i], max * nums[i]),
						nums[i]);
				max = maxCur;
				min = minCur;
				result = Math.max(result, max);
			}
		}
		return result;
	}
}
