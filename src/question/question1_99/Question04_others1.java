package question.question1_99;

/*
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 */
//这道题好难啊——一开始的end = len1 * 2我就理解不了，然后取数还是nums1[(mid1 - 1) / 2]，这个原理一定要弄明白
//这种方法我暂时只能先硬记住了，用在别的题上我肯定是实现不了的
public class Question04_others1 {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len1 = nums1.length, len2 = nums2.length;
		if (len1 > len2)
			return findMedianSortedArrays(nums2, nums1);
		int start = 0, end = len1 * 2;
		while (start <= end) {
			int mid1 = (start + end) / 2;
			int mid2 = len1 + len2 - mid1;
			int l1 = mid1 == 0 ? Integer.MIN_VALUE : nums1[(mid1 - 1) / 2];
			int r1 = mid1 == len1 * 2 ? Integer.MAX_VALUE : nums1[mid1 / 2];
			int l2 = mid2 == 0 ? Integer.MIN_VALUE : nums2[(mid2 - 1) / 2];
			int r2 = mid2 == len2 * 2 ? Integer.MAX_VALUE : nums2[mid2 / 2];
			if (l1 > r2)
				end = mid1 - 1;
			else if (l2 > r1)
				start = mid1 + 1;
			else
				return ((double) Math.max(l1, l2) + (double) Math.min(r1, r2)) / 2;
		}
		return 0;
	}
}a
