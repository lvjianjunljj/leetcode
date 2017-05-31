package question.question200_299;
/*
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. 
 * Find the two elements that appear only once.
 */
public class Question260_sort {
	public int[] singleNumber(int[] nums) {
		int diff = 0;
		for (int num : nums) {
			diff ^= num;
		}
		// 使用n&(~(n-1))可以取出元素的最后一个1的位置。
		int bitFlag = (diff & (~(diff - 1)));
		int[] res = new int[2];
		//然后通过循环，元素A和元素B分别在两个不同的序列里面了
		for (int num : nums) {
			if ((num & bitFlag) == 0) {
				res[0] ^= num;
			} else {
				res[1] ^= num;
			}
		}
		return res;
	}
}
