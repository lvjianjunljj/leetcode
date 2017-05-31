package question.question1_99;
/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 */
//我自己确实是根据题目给的标签用贪心算法进行运算，但是耗时还是较长
public class Question55_own {
	public boolean canJump(int[] nums) {
		int n = nums.length;
		int start = 0;
		int end = nums[0];
		while (start < end) {
			int tran = end;
			for (int i = start; i <= tran; i++) {
				if (i < n - 1)
					end = Math.max(end, i + nums[i]);
				else
//					end = n - 1;
					//用直接返回true代替对end赋最后一个值，可以减小耗时，就和网上给的第一个答案others1耗时一样了。
					return true;
			}
			start = tran;
		}
		return end > n - 2;
	}
}
