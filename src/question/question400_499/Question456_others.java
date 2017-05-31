package question.question400_499;

/*
 * Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak 
 * such that i < j < k and ai < ak < aj. Design an algorithm that takes a list of n numbers 
 * as input and checks whether there is a 132 pattern in the list.
 * Note: n will be less than 15,000.
 * Example 1:
 * Input: [1, 2, 3, 4]
 * Output: False
 * Explanation: There is no 132 pattern in the sequence.
 */
import java.util.Stack;

//用栈做才是正确的，其中的while语句使得栈中的数字都是顺序排列的（这种想法和难啊）
public class Question456_others {
	public boolean find132pattern(int[] nums) {
		int s = Integer.MIN_VALUE;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] < s) {
				return true;
			} else {
				while (!stack.isEmpty() && nums[i] > stack.peek()) {
					s = stack.pop();
				}
				stack.push(nums[i]);
			}
		}
		return false;
	}
}
