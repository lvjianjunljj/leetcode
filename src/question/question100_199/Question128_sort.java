package question.question100_199;

import java.util.Arrays;
/*
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 */
public class Question128_sort {
	public int longestConsecutive(int[] nums) {
		Arrays.sort(nums);
		int n = nums.length;
		int mark = 1;
		int result = 1;
		int j = 0;
		for (int i = 1; i < n; i++) {
			if (nums[i] == nums[j]) {
				j = i;
				continue;
			}
			if (nums[i] - nums[j] == 1) {
				j++;
				mark++;
				if (mark > result) {
					result = mark;
				}
			} else {
				j = i;
				mark = 1;
			}
		}
		return result;
	}
}
