package question.question200_299;
/*
 * Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 */
//我已经将3层相加循环降成了2层循环（用int[][] sum来维护和，类似于动态规划，这种循环求和都能这样维护），但是依然超时
public class Question209_own {
	public int minSubArrayLen(int s, int[] nums) {
		int n = nums.length;
		int result = Integer.MAX_VALUE;
		int[][] sum = new int[n + 1][n + 1];
		for (int i = 0; i < n; i++) {
			sum[i + 1][i + 1] = nums[i];
		}
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				sum[i + 1][j + 1] = sum[i + 1][j] + nums[j];
				if (sum[i + 1][j + 1] >= s) {
					result = Math.max(result, j - i + 1);
				}
			}
		}
		return result;
	}
}
