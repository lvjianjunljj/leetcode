package question.question500_599;

import java.util.*;

import help.TreeNode;

/**
 * @author lvjj
 * @date 2017年4月16日Given an array of integers and an integer k, you need to find
 *       the number of unique k-diff pairs in the array. Here a k-diff pair is
 *       defined as an integer pair (i, j), where i and j are both numbers in
 *       the array and their absolute difference is k.
 * 
 *       Example 1: Input: [3, 1, 4, 1, 5], k = 2 Output: 2 Explanation: There
 *       are two 2-diff pairs in the array, (1, 3) and (3, 5). Although we have
 *       two 1s in the input, we should only return the number of unique pairs.
 *       Example 2: Input:[1, 2, 3, 4, 5], k = 1 Output: 4 Explanation: There
 *       are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
 *       Example 3: Input: [1, 3, 1, 5, 4], k = 0 Output: 1 Explanation: There
 *       is one 0-diff pair in the array, (1, 1). Note: The pairs (i, j) and (j,
 *       i) count as the same pair. The length of the array won't exceed 10,000.
 *       All the integers in the given input belong to the range: [-1e7, 1e7].
 */
public class Question532_own {
	// mark一下 这个题做的不太对 测试案例不全面
	public int findPairs(int[] nums, int k) {
		if (nums == null || nums.length < 2) {
			return 0;
		}
		Arrays.sort(nums);
		int i = 0, j = 1, res = 0;
		while (j < nums.length && i < nums.length) {
			if (i == j) {
				j++;
			} else if (i > 0 && nums[i] == nums[i - 1]) {
				i++;
			} else if (j > 1 && nums[j] == nums[j - 1] && j - i > 1) {
				j++;
			} else if (nums[j] - nums[i] == k) {
				res++;
				i++;
				j++;
			} else if (nums[j] - nums[i] > k) {
				i++;
			} else {
				j++;
			}
		}
		return res;
	}
}
