package question.question300_399;

import java.util.ArrayList;
import java.util.Arrays;
//稍微做了一些调整，代码精简了一些，但是耗时并没有变短
public class Question324_own2 {
	public void wiggleSort(int[] nums) {
		int n = nums.length;
		Arrays.sort(nums);
		ArrayList<Integer> array = new ArrayList<Integer>();
		if (n % 2 == 0 && n > 1 && nums[n / 2] == nums[n / 2 - 1]) {
			for (int i = n / 2 - 1; i > -1; i--)
				array.add(nums[i]);
			for (int i = n - 1; i > n / 2 - 1; i--) {
				array.add(nums[i]);
			}
		} else {
			for (int i = 0; i < n; i++)
				array.add(nums[i]);
		}
		int k = n % 2 == 0 ? n / 2 : n / 2 + 1;
		for (int i = 0; i < n / 2; i++) {
			nums[i * 2] = array.get(i);
			nums[i * 2 + 1] = array.get(i + k);
		}
		if (n % 2 != 0)
			nums[n - 1] = array.get(n / 2);
	}
}
