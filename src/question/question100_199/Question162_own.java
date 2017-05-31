package question.question100_199;

/*
 * A peak element is an element that is greater than its neighbors.
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * You may imagine that num[-1] = num[n] = -∞.
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 * click to show spoilers.
 * Note:
 * Your solution should be in logarithmic complexity.
 */
//以为这特么也太简单了吧——没看到Note的logarithmic complexity——不会做
public class Question162_own {
	public int findPeakElement(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			int be = i == 0 ? Integer.MIN_VALUE : nums[i - 1];
			int in = nums[i];
			int af = i == nums.length - 1 ? Integer.MIN_VALUE : nums[i + 1];
			if (in >= be && in >= af)
				return i;
			else if (in >= af)
				i++;
		}
		return -1;
	}
}
