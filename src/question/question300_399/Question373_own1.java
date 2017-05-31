package question.question300_399;

/*
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 * Define a pair (u,v) which consists of one element from the first array and one element from the second array.
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 * Example 1:
 * Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3
 * Return: [1,2],[1,4],[1,6]
 * The first 3 pairs are returned from the sequence:
 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * Example 2:
 * Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2
 * Return: [1,1],[1,1]
 * The first 2 pairs are returned from the sequence:
 * [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * Example 3:
 * Given nums1 = [1,2], nums2 = [3],  k = 3 
 * Return: [1,3],[2,3]
 * All possible pairs are returned from the sequence:
 * [1,3],[2,3]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//我能想到的是把每对值和其和都存下来然后按和那一列进行排序然后输出——我就是想写一下二维数组按某列排序的方法
public class Question373_own1 {
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		int len1 = nums1.length, len2 = nums2.length;
		int[][] data = new int[len1 * len2][3];
		for (int i = 0; i < len1; i++) {
			for (int j = 0; j < len2; j++) {
				data[len2 * i + j][0] = nums1[i] + nums2[j];
				data[len2 * i + j][1] = nums1[i];
				data[len2 * i + j][2] = nums2[j];
			}
		}
		Comparator c = new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((int[]) o1)[0])
						.compareTo(((int[]) o2)[0]);
			}
		};
		Arrays.sort(data, c);
		List<int[]> res = new ArrayList<int[]>();
		for (int i = 0; i < Math.min(k, data.length); i++)
			res.add(new int[] { data[i][1], data[i][2] });
		return res;
	}
}
