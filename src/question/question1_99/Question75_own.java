package question.question1_99;
/*
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 */
//只有三个值的排序，所以用two pointers遍历一遍做就很快
public class Question75_own {
	public void sortColors(int[] nums) {
		int i = 0, j = 0, n = nums.length;
		for (int k = 0; k < n; k++) {
			if (nums[k] == 0) {
				tran(nums, i, k);
				if (i != j)
					tran(nums, j, k);
				i++;
				j++;
			} else if (nums[k] == 1) {
				tran(nums, j, k);
				j++;
			}
		}
	}

	public static void tran(int[] nums, int i, int j) {
		int tran = nums[i];
		nums[i] = nums[j];
		nums[j] = tran;
	}
}
