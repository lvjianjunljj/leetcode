package question.question1_99;

//网上给的耗时最少的一种方法，用倒序做
//遍历数组，其实只有遇到值为零的点需要判断，不为零的点一定可以向下走，所以根本不用判断
public class Question55_others2 {
	//网上给的方法
	// public boolean canJump(int[] nums) {
	// if (nums.length < 2)
	// return true;
	// for (int curr = nums.length - 2; curr >= 0; curr--) {
	// if (nums[curr] == 0) {
	// int neededJumps = 1;
	// while (neededJumps > nums[curr]) {
	// neededJumps++;
	// curr--;
	// if (curr < 0)
	// return false;
	// }
	// }
	// }
	// return true;
	// }
	//自己重写的，思路是一样的
	public boolean canJump(int[] nums) {
		if (nums.length < 2)
			return true;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] == 0) {
				int cur = i;
				while (nums[i] + i <= cur) {
					i--;
					if (i < 0)
						return false;
				}
			}
		}
		return true;
	}
}
