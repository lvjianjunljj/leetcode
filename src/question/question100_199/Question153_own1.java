package question.question100_199;

/*
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 */

//用递归实现binary search，还是非常容易的（前面的都比后面的大）
public class Question153_own1 {
	public int findMin(int[] nums) {
		return search(nums, 0, nums.length - 1);
	}

	private int search(int[] nums, int i, int j) {
		if (i >= j)
			return nums[j];
		int mid = (i + j) / 2;
		if (nums[mid] > nums[j])
			return search(nums, mid + 1, j);
		else
			return search(nums, i, mid);
	}
}
