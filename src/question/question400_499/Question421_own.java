package question.question400_499;
/*
 * Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.
 * Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.
 * Could you do this in O(n) runtime?
 * Example:
 * Input: [3, 10, 5, 25, 2, 8]
 * Output: 28
 * Explanation: The maximum result is 5 ^ 25 = 28.
 */

//暴力破解其实也不是很慢，要好好想想怎么在On时间复杂度内完成
public class Question421_own {
	public int findMaximumXOR(int[] nums) {
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (res < (nums[i] ^ nums[j])) {
					res = nums[i] ^ nums[j];
				}
			}
		}
		return res;
	}
}
