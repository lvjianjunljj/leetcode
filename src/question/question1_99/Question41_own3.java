package question.question1_99;
//不用union find 的话用计数排序也是能做的
public class Question41_own3 {
	public int firstMissingPositive(int[] nums) {
		boolean[] list = new boolean[nums.length];
		for (int i : nums) {
			if (i > 0 && i <= nums.length) {
				list[i - 1] = true;
			}
		}
		for (int i = 0; i < list.length; i++) {
			if (!list[i]) {
				return i + 1;
			}
		}
		return nums.length + 1;
	}
}
