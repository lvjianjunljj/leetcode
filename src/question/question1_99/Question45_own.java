package question.question1_99;

/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * For example:
 * Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 */
//用贪心做还是很快就能出来的
public class Question45_own {
	public int jump(int[] nums) {
		int step = 0, start = 0, end = 0;
		while (end < nums.length - 1) {
			step++;
			int tmp = end;
			for (int i = start; i <= end; i++) {
				if (i + nums[i] > tmp) {
					tmp = i + nums[i];
				}
			}
			start = end + 1;
			end = tmp;
		}
		return step;
	}
}
