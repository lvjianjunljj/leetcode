package question.question1_99;
/*
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 */

//用二分法一做就出来了，注意一下边界条件的取值就能把start和end区别出来，简单
public class Question34_own {
	public int[] searchRange(int[] nums, int target) {
		int[] res = new int[2];
		int i = 0, j = nums.length - 1;
		while (i < j) {
			int mid = (i + j) / 2;
			if (nums[mid] < target) {
				i = mid + 1;
			} else {
				j = mid;
			}
		}
		if (nums[i] != target) {
			return new int[] { -1, -1 };
		} else {
			res[0] = i;
		}
		i = 0;
		j = nums.length - 1;
		while (i < j) {
			int mid = (i + j + 1) / 2;
			if (nums[mid] > target) {
				j = mid - 1;
			} else {
				i = mid;
			}
		}
		res[1] = j;
		return res;
	}
}
