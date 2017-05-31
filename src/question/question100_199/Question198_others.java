package question.question100_199;
//这个方法确实要快一些——将之前的数封装成一个数而不是存到数组中
public class Question198_others {
	public int rob(int[] nums) {
		int temp, last = 0, now = 0;
		for (int n : nums) {
			temp = now;
			now = Math.max(now, last + n);
			last = temp;
		}
		return now;
	}
}
