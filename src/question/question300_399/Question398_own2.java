package question.question300_399;

import java.util.Random;

//他既然说数据量太大，意思就是不让用多余的存储空间喽——那这种每次pick的时候都遍历一遍数组的方法也是可以的
//我以前写过类似的方法，很好写
public class Question398_own2 {
	int[] nums;
	Random ra;

	public Question398_own2(int[] nums) {
		this.nums = nums;
		ra = new Random();
	}

	public int pick(int target) {
		int count = 1, index = 0;
		for (int i = 0; i < nums.length; i++)
			if (nums[i] == target && ra.nextInt(count++) == 0)
				index = i;
		return index;
	}
}
