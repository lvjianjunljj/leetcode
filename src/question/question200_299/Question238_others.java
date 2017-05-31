package question.question200_299;
//没有这种意识，完全可以对数组进行反向遍历，这样乘起来就正好空掉当前的元素
public class Question238_others {
	public int[] productExceptSelf(int[] nums) {
		int back = 1;
		int[] res = new int[nums.length];
		res[0] = 1;
		for (int i = 1; i < nums.length; i++)
			res[i] = res[i - 1] * nums[i - 1];
		for (int i = nums.length - 2; i > -1; i--) {
			back *= nums[i + 1];
			res[i] *= back;
		}
		return res;
	}
}
