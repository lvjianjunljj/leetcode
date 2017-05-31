package question.question300_399;

/*
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 * Example:
 * (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6]. 
 * (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].
 */
import java.util.ArrayList;
import java.util.Arrays;
//因为假设所有的输入均有效，所以这种方法有取巧的成分
public class Question324_own1 {
	public void wiggleSort(int[] nums) {
		int n = nums.length;
		Arrays.sort(nums);
		if (n % 2 == 0 && n > 1 && nums[n / 2] == nums[n / 2 - 1]) {
			for (int i = 0; i < n / 2; i++) {
				int tran = nums[i];
				nums[i] = nums[i + n / 2];
				nums[i + n / 2] = tran;
			}
			for (int i = 0; i < n / 2; i++) {
				int tran = nums[i];
				nums[i] = nums[n - 1 - i];
				nums[n - 1 - i] = tran;
			}
		}
		ArrayList<Integer> array = new ArrayList<Integer>();
		int k = n % 2 == 0 ? n / 2 : n / 2 + 1;
		for (int i = 0; i < n / 2; i++) {
			array.add(nums[i]);
			array.add(nums[i + k]);
		}
		if (n % 2 != 0)
			array.add(nums[n / 2]);
		for (int i = 1; i < n; i++) {
			nums[i] = array.get(i);
		}
	}
}
