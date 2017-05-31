package question.question300_399;
/*
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 */
//其实用一维数组完全可以解决
public class Question303_others {
	int[] nums;

	public Question303_others(int[] nums) {
		for (int i = 1; i < nums.length; i++)
			nums[i] += nums[i - 1];

		this.nums = nums;
	}

	public int sumRange(int i, int j) {
		if (i == 0)
			return nums[j];

		return nums[j] - nums[i - 1];
	}
	//一开始以为要用二维数组
	// private ArrayList<ArrayList<Integer>> sums = new
	// ArrayList<ArrayList<Integer>>();
	//    
	// public NumArray(int[] nums) {
	// int m = nums.length;
	// for (int i = 0; i < m; i++) {
	// ArrayList<Integer> sum = new ArrayList<Integer>();
	// for (int j = i; j < m; j++) {
	// if (i == j)
	// sum.add(nums[i]);
	// else
	// sum.add(sum.get(j - i - 1) + nums[j]);
	// }
	// sums.add(sum);
	// }
	// }
	//
	// public int sumRange(int i, int j) {
	// return sums.get(i).get(j - i);
	// }
}
