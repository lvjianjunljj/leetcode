package question.question300_399;

/*
 * Given a sorted positive integer array nums and an integer n, add/patch elements to the array such that any number in range [1, n] inclusive can be formed by the sum of some elements in the array. Return the minimum number of patches required.
 * Example 1:
 * nums = [1, 3], n = 6
 * Return 1.
 * Combinations of nums are [1], [3], [1,3], which form possible sums of: 1, 3, 4.
 * Now if we add/patch 2 to nums, the combinations are: [1], [2], [3], [1,3], [2,3], [1,2,3].
 * Possible sums are 1, 2, 3, 4, 5, 6, which now covers the range [1, 6].
 * So we only need 1 patch.
 */
//这个贪心算法确实不错，虽然想到了最后的while循环里的sum = sum * 2 + 1，但是for循环没有想到（sum + 1 < nums[i]的情况没有想到怎么办）
public class Question330_others {
	public int minPatches(int[] nums, int n) {
		int count = 0;
		// 这里要用long而不能用int，因为sum在运算过程中可能会超出int 的数据范围而造成结果出错
		long sum = 0;
		for (int i = 0; i < nums.length; i++) {
			while (sum < n && sum + 1 < nums[i]) {
				count++;
				sum = sum * 2 + 1;
			}
			if (sum >= n)
				return count;
			sum += nums[i];
		}
		while (sum < n) {
			count++;
			sum = sum * 2 + 1;
		}
		return count;
	}
}
