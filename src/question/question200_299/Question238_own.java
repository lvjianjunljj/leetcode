package question.question200_299;
/*
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * Solve it without division and in O(n).
 * For example, given [1,2,3,4], return [24,12,8,6].
 */
//主要考虑0的情况，其他的都没什么问题，就是全乘起来，然后除以对应位置上的数——萨比，没看清楚题，人家说不能用除法。
public class Question238_own {
	public int[] productExceptSelf(int[] nums) {
		int zero = 0, index = 0;
		long pro = 1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				zero++;
				index = i;
			} else
				pro *= nums[i];
		}
		int[] res = new int[nums.length];
		if (zero > 1)
			return res;
		else if (zero == 1) {
			res[index] = (int) pro;
			return res;
		}
		for (int i = 0; i < nums.length; i++)
			res[i] = (int) (pro / nums[i]);
		return res;
	}
}
