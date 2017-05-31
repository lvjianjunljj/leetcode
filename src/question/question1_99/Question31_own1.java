package question.question1_99;

import java.util.Arrays;
/*
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 */
//自己完成——数学逻辑重一些。
public class Question31_own1{
	public void nextPermutation(int[] nums) {
		int n = nums.length;
		int mark = n - 1;
		for (int i = n - 1; i > 0; i--) {
			if (nums[i] > nums[i - 1]) {
				for (int j = i; j < n; j++) {
					if (nums[j] <= nums[i - 1]) {
						mark = j - 1;
						break;
					}
				}
				int tran = nums[i - 1];
				nums[i - 1] = nums[mark];
				nums[mark] = tran;
				int[] sub = new int[n - i];
				for (int k = i; k < n; k++) {
					sub[k - i] = nums[k];
				}
				Arrays.sort(sub);
				for (int k = i; k < n; k++) {
					nums[k] = sub[k - i];
				}
				return;
			}
		}
		Arrays.sort(nums);
	}
}
