package question.question200_299;

/*
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * For example,
 * Given nums = [0, 1, 3] return 2.
 */
//根据之前的一道找一个未重复出现的数字的题的方法
//网上给的多数答案居然是对1到n求和这种low逼方法
public class Question268_own {
	public int missingNumber(int[] nums) {
		int n = nums.length;
		int result = 0;
		for (int i = 0; i < n; i++)
			result ^= nums[i];
		for (int i = 1; i < n + 1; i++)
			result ^= i;
		return result;
	}
}
