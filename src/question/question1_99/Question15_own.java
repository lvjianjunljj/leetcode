package question.question1_99;

/*
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * Note: The solution set must not contain duplicate triplets.
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 A solution set is:
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//调用了ArrayList的contains方法，但是这个方法很耗时
public class Question15_own {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums.length < 3)
			return res;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			//加一个这个判断会很降低耗时，不然就会超时
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			int start = i + 1;
			int end = nums.length - 1;
			while (start < end) {
				int sum = nums[i] + nums[start] + nums[end];
				if (sum > 0)
					end--;
				else if (sum < 0)
					start++;
				else {
					List<Integer> element = new ArrayList<Integer>();
					element.add(nums[i]);
					element.add(nums[start]);
					element.add(nums[end]);
					//用这个判断来剔除重复不如others里的方法来的巧妙和省时
					if (!res.contains(element))
						res.add(element);
					end--;
					start++;
				}
			}
		}
		return res;
	}
}
