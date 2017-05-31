package question.question1_99;

//用这种遍历一遍的贪心做确实快一点
public class Question55_own2 {
	public boolean canJump(int[] nums) {
		int start = 0, end = 0;
		while (start < nums.length - 1) {
			int tmp = end;
			for (int i = start; i <= end; i++) {
				if (tmp < i + nums[i]) {
					tmp = i + nums[i];
				}
			}
			if (tmp >= nums.length - 1) {
				return true;
			}
			if (tmp == end) {
				return false;
			}
			start = end + 1;
			end = tmp;
		}
		return true;
	}
}
