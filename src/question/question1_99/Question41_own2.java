package question.question1_99;
//根据答案的思路重写的方法，有点像Union Find。
public class Question41_own2 {
	public int firstMissingPositive(int[] nums) {
		int n = nums.length;
		if (n == 0 || (n == 1 && nums[0] != 1))
			return 1;
		for (int i = 0; i < n; i++) {
			if (nums[i] < 1 || nums[i] > n)
				nums[i] = 0;
			//本来已经想到了，但是存在nums[nums[i] - 1] == nums[i]的情况，加一步判断便可以了
			else if (nums[nums[i] - 1] != nums[i]) {
				int tran = nums[i];
				nums[i] = nums[nums[i] - 1];
				nums[tran - 1] = tran;
				i--;
			}
		}
		for (int i = 0; i < n; i++)
			if (nums[i] != i + 1)
				return i + 1;
		return n + 1;
	}
}
