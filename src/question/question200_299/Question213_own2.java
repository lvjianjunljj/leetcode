package question.question200_299;
//模仿Question198的others方法，然而耗时并没有降低——但是没有用多余的存储空间
//应该没有更好的方法了
public class Question213_own2 {
	public int rob(int[] nums) {
		if (nums.length == 1)
			return nums[0];
		int temp, now1 = 0, now2 = 0, last = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			temp = now1;
			now1 = Math.max(now1, last + nums[i]);
			last = temp;
		}
		last = 0;
		for (int i = 1; i < nums.length; i++) {
			temp = now2;
			now2 = Math.max(now2, last + nums[i]);
			last = temp;
		}
		return Math.max(now1, now2);
	}
}
