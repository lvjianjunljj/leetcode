package question.question300_399;

import java.util.Arrays;
//和我的想法是一样的，他是在任何情况下都对前后两个数组进行了倒序，但是是在添加到新数组的时候倒序的，所以耗时低一些（mid这个值找的很好）
public class Question324_others1 {
	public void wiggleSort(int[] nums) {
		Arrays.sort(nums);
		int[] temp = new int[nums.length];
		int mid = nums.length % 2 == 0 ? nums.length / 2 - 1 : nums.length / 2;
		int index = 0;
		for (int i = 0; i <= mid; i++) {
			temp[index] = nums[mid - i];
			if (index + 1 < nums.length)
				temp[index + 1] = nums[nums.length - i - 1];
			index = index + 2;
		}
		for (int i = 0; i < nums.length; i++) {
			nums[i] = temp[i];
		}
	}
}
