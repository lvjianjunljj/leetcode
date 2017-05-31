package question.question1_99;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * Note:
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to 
 * hold additional elements from nums2. 
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * 
 */

//从后往前就立马出来了，哪有这么多事
public class Question88_others {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1, j = n - 1, k = m + n - 1;
		while (i >= 0 && j >= 0) {
			nums1[k--] = nums1[i] >= nums2[j] ? nums1[i--] : nums2[j--];
		}
		while (i >= 0 || j >= 0) {
			nums1[k--] = j < 0 ? nums1[i--] : nums2[j--];
		}
	}
}
