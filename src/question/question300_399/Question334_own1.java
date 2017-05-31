package question.question300_399;

/*
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 * Formally the function should:
 * Return true if there exists i, j, k 
 * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 * Your algorithm should run in O(n) time complexity and O(1) space complexity.
 * Examples:
 * Given [1, 2, 3, 4, 5],
 * return true.
 * Given [5, 4, 3, 2, 1],
 * return false.
 */

//遍历整个数组，将其视为3个递增序列的中间一个向两边再遍历——空间复杂度为O1但是耗时极高
public class Question334_own1 {
	public boolean increasingTriplet(int[] nums) {
		for (int i = 1; i < nums.length - 1; i++) {
			int s = i - 1, e = i + 1;
			while (s >= 0 && nums[s] >= nums[i])
				s--;
			while (e < nums.length && nums[e] <= nums[i])
				e++;
			if (s >= 0 && e < nums.length)
				return true;
		}
		return false;
	}
}
