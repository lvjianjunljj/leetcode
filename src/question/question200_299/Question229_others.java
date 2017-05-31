package question.question200_299;
/*
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.
 */
import java.util.ArrayList;
import java.util.List;

//仔细想想才能想到最多只会有两个数，将可能的两个数确定一下然后再进行判断就行（简直是机智）
public class Question229_others {
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> result = new ArrayList<Integer>();
		if (nums.length == 0)
			return result;
		int len = nums.length, num1 = nums[0], num2 = nums[0], count1 = 0, count2 = 0;
		for (int i = 0; i < len; i++) {
			if (nums[i] == num1)
				count1++;
			else if (nums[i] == num2)
				count2++;
			else if (count1 == 0) {
				num1 = nums[i];
				count1++;
			} else if (count2 == 0) {
				num2 = nums[i];
				count2++;
			} else {
				count1--;
				count2--;
			}
		}
		count1 = 0;
		count2 = 0;
		for (int i : nums) {
			if (i == num1)
				count1++;
			else if (i == num2)
				count2++;
		}
		if (count1 > len / 3)
			result.add(num1);
		if (count2 > len / 3)
			result.add(num2);
		return result;
	}
}
