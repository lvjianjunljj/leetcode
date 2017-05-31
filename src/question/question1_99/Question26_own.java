package question.question1_99;
/*
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 */
//我的方法是找到重复点并进行标记最后整合，但显然非常麻烦，直接用返回值做标记点进行操作就比较简单了
public class Question26_own {
	public int removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int result = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1]) {
				nums[result] = nums[i];
				result++;
			}
		}
		return result;
	}
}
