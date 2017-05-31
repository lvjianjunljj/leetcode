package question.question1_99;
/*
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution.
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */

import java.util.HashMap;
import java.util.Map;
//备注里的方法是我自己的方法，是用ArrayList<Integer>来实现的，
//就是在list中寻找target - nums[i])而不是用数组两层遍历所有的i和j（数组没有indexOf方法）
//显然hashMap的get方法相比耗时要短一些——注意这个方法不需要一来是就将所以的数据先全加到HashMap中
public class Question01_others {
	public int[] twoSum(int[] numbers, int target) {
		// ArrayList<Integer> list = new ArrayList<Integer>();
		// int n = nums.length;
		// int[] res = new int[2];
		// for (int i = 0; i < n; i++) {
		// if (list.indexOf(target - nums[i]) != -1) {
		// res[0] = i;
		// res[1] = list.indexOf(target - nums[i]) ;
		// break;
		// }
		// list.add(nums[i]);
		// }
		// return res;
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(target - numbers[i])) {
				result[1] = i;
				result[0] = map.get(target - numbers[i]);
				return result;
			}
			map.put(numbers[i], i);
		}
		return result;
	}
}
