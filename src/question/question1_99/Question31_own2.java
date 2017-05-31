package question.question1_99;

import java.util.Arrays;
//并不是很难，挺简单的，思路都是一样的
public class Question31_own2 {
	public void nextPermutation(int[] nums) {
		int index = nums.length - 1;
		while (index > 0 && nums[index - 1] >= nums[index]) {
			index--;
		}
		if (index == 0) {
			Arrays.sort(nums);
		} else {
			for (int i = index; i <= nums.length; i++) {
				if (i == nums.length || nums[i] <= nums[index - 1]) {
					int tmp = nums[i - 1];
					nums[i - 1] = nums[index - 1];
					nums[index - 1] = tmp;
					break;
				}
			}
			Arrays.sort(nums, index, nums.length);
		}
	}
}
