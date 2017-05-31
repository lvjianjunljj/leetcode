package question.question100_199;

/*
 * Follow up for "Find Minimum in Rotated Sorted Array":
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * The array may contain duplicates.
 */

//和153不同的是存在重复数字，所以在mid对应的值和j对应的值相同时只能两边都判断了——并不符合要求
public class Question154_own {
	public int findMin(int[] nums) {
		return search(nums, 0, nums.length - 1);
	}

	private int search(int[] nums, int i, int j) {
		if (i >= j)
			return nums[j];
		int mid = (i + j) / 2;
		if (nums[mid] > nums[j])
			return search(nums, mid + 1, j);
		else if (nums[mid] < nums[j])
			return search(nums, i, mid);
		else
			return Math.min(search(nums, mid + 1, j), search(nums, i, mid));
	}
}
