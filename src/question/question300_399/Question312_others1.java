package question.question300_399;

/*
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
 * Find the maximum coins you can collect by bursting the balloons wisely.
 * Note: 
 * (1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 * (2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * Example:
 * Given [3, 1, 5, 8]
 * Return 167
 * nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 * coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 */
//正统思路，其他的方法都是在其思路上进行改进的。
//既然选择第一个剔掉的会使得数组的相邻改变，那就先选择最后一个剔掉的，然后最后选择第一个剔掉的，这样数组的相邻属性就不会被改变，想法简直是太巧妙了
public class Question312_others1 {
	public int maxCoins(int[] nums) {
		//加入剔零的过程并没有减少多少耗时。
		if (nums == null || nums.length == 0)
			return 0;

		int[][] dp = new int[nums.length][nums.length];
		for (int len = 1; len <= nums.length; len++) {
			for (int start = 0; start <= nums.length - len; start++) {
				int end = start + len - 1;
				for (int i = start; i <= end; i++) {
					int coins = nums[i] * getValue(nums, start - 1)
							* getValue(nums, end + 1);
					coins += i != start ? dp[start][i - 1] : 0;
					coins += i != end ? dp[i + 1][end] : 0;
					dp[start][end] = Math.max(dp[start][end], coins);
				}
			}
		}
		return dp[0][nums.length - 1];
	}

	private int getValue(int[] nums, int i) { // Deal with num[-1] and
		// num[num.length]
		if (i < 0 || i >= nums.length) {
			return 1;
		}
		return nums[i];
	}
}
