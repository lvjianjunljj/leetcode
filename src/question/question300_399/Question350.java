package question.question300_399;

import java.util.ArrayList;
/*
 * Given two arrays, write a function to compute their intersection.
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 */
//这里要求重复的交集元素存储多次，所以不能用HashSet而只能用ArrayList进行存储，所以时间会长一些
public class Question350 {
	public int[] intersect(int[] nums1, int[] nums2) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> array = new ArrayList<Integer>();
		for (int i : nums1) {
			array.add(i);
		}
		for (int i : nums2) {
			if (array.contains(i)) {
				//因为array中存储的类是Integer，而remove(int index)方法是按索引删除，所以只能这样进行删除
				array.remove(array.indexOf(i));
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
