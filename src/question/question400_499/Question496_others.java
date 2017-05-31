package question.question400_499;

import java.util.*;
/**
 * @author lvjj
 * @date 2017年4月15日 You are given two arrays (without duplicates) nums1 and
 *       nums2 where nums1’s elements are subset of nums2. Find all the next
 *       greater numbers for nums1's elements in the corresponding places of
 *       nums2.
 * 
 *       The Next Greater Number of a number x in nums1 is the first greater
 *       number to its right in nums2. If it does not exist, output -1 for this
 *       number.
 * 
 *       Example 1: Input: nums1 = [4,1,2], nums2 = [1,3,4,2]. Output: [-1,3,-1]
 *       Explanation: For number 4 in the first array, you cannot find the next
 *       greater number for it in the second array, so output -1. For number 1
 *       in the first array, the next greater number for it in the second array
 *       is 3. For number 2 in the first array, there is no next greater number
 *       for it in the second array, so output -1.
 */
public class Question496_others {
	//没想到用栈这种数据类型（进阶在503和556）
	public int[] nextGreaterElement(int[] findNums, int[] nums) {
		Stack<Integer> stack = new Stack<Integer>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : nums) {
			while (!stack.isEmpty() && stack.peek() < i) {
				map.put(stack.pop(), i);
			}
			stack.push(i);
		}
		int[] res = new int[findNums.length];
		for (int i = 0; i < findNums.length; i++) {
			res[i] = map.getOrDefault(findNums[i], -1);
		}
		return res;
	}
}
