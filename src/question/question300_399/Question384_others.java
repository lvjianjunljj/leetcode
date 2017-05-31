package question.question300_399;

import java.util.Random;

//他这个将数组随机打乱的方法也是比较巧妙的啊
public class Question384_others {

	int[] nums;
	Random ran;

	public Question384_others(int[] nums) {
		this.nums = nums;
		ran = new Random();
	}

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return nums;
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		int[] a = nums.clone();
		for (int i = 1; i < a.length; i++)
			swap(a, i, ran.nextInt(i + 1));
		return a;
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
