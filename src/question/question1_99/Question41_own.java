package question.question1_99;

import java.util.Arrays;

/*
 * Given an unsorted integer array, find the first missing positive integer.
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * Your algorithm should run in O(n) time and uses constant space.
 */
//实在不会做啊，我只能排序啊，你说遍历一遍怎么做！！！
public class Question41_own {
	public int firstMissingPositive(int[] nums) {
		int n = nums.length;
		if (n == 0 || (n == 1 && nums[0] != 1))
			return 1;
		if (n == 1 && nums[0] == 1)
			return 2;
		Arrays.sort(nums);
		if (nums[0] > 1 || nums[n - 1] < 1)
			return 1;
		for (int i = 1; i < n; i++) {
			if (nums[i - 1] < 1 && nums[i] > 1)
				return 1;
			else if (nums[i - 1] > 0 && nums[i - 1] + 1 < nums[i])
				return nums[i - 1] + 1;
		}

		return nums[n - 1] + 1;
	}
}
