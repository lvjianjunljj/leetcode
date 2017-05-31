package question.question300_399;

import java.util.ArrayList;
import java.util.HashSet;

/*
 * Given two arrays, write a function to compute their intersection.
 * Each element in the result must be unique.
 * The result can be in any order.
 */
//用HashSet做会快一点，因为HashSet的remove方法时间复杂度是O1而ArrayList的remove方法时间复杂度是On
public class Question349 {
	public int[] intersection(int[] nums1, int[] nums2) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i : nums1) {
			set.add(i);
		}
		for (int i : nums2) {
			if (set.contains(i)) {
				set.remove(i);
				list.add(i);
			}
		}
		int[] result = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}
		return result;
	}
}
