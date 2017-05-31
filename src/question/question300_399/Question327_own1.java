package question.question300_399;

/*
 * Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
 * Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ≤ j), inclusive.
 */
//动态规划做已然超时。看来只能用树做了
public class Question327_own1 {
	public int countRangeSum(int[] nums, int lower, int upper) {
		int n = nums.length;
		int[][] grid = new int[n][n];
		return aux(nums, grid, 0, n - 1, lower, upper);
	}

	private int aux(int[] nums, int[][] grid, int i, int j, int lower, int upper) {
		if (i > j) {
			return 0;
		}
		if (grid[i][j] > 0) {
			return grid[i][j];
		}
		if (i == j) {
			if (grid[i][i] <= upper && grid[i][i] >= lower) {
				grid[i][j] = 1;
				return 1;
			} else {
				return 0;
			}
		}
		int k = (i + j) / 2;
		grid[i][j] = aux(nums, grid, i, k - 1, lower, upper)
				+ aux(nums, grid, k + 1, j, lower, upper)
				+ cross(nums, i, j, k, lower, upper);
		return grid[i][j];
	}

	private int cross(int[] nums, int i, int j, int k, int lower, int upper) {
		int result = 0;
		for (int m = i; m < k + 1; m++) {
			for (int n = k; n < j + 1; n++) {
				int sum = 0;
				for (int p = m; p < n + 1; p++) {
					sum += nums[p];
				}
				if (sum <= upper && sum >= lower) {
					result++;
				}
			}
		}
		return result;
	}
}
