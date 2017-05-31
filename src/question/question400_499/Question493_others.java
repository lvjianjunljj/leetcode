package question.question400_499;

/**
 * @author lvjj
 * @date 2017年4月22日 Given an array nums, we call (i, j) an important reverse
 *       pair if i < j and nums[i] > 2*nums[j].
 * 
 *       You need to return the number of important reverse pairs in the given
 *       array.
 * 
 *       Example1:
 * 
 *       Input: [1,3,2,3,1] Output: 2 Example2:
 * 
 *       Input: [2,4,3,5,1] Output: 3 Note: The length of the given array will
 *       not exceed 50,000. All the numbers in the input array are in the range
 *       of 32-bit integer.
 */
// 用归并排序求逆序对是正统思路，但是这道题有点改动，所以要麻烦一点，也没有到与之相比更简单的方法了
public class Question493_others {
	int res = 0;

	public int reversePairs(int[] nums) {
		mergeSort(nums, 0, nums.length - 1);
		// System.out.println(Arrays.toString(nums));
		return res;
	}

	private void mergeSort(int[] nums, int start, int end) {
		if (start >= end) {
			return;
		} else {
			int mid = (start + end) / 2;
			mergeSort(nums, start, mid);
			mergeSort(nums, mid + 1, end);
			merge(nums, start, mid, end);
		}
	}

	private void merge(int[] nums, int start, int mid, int end) {
		int[] tmp = new int[end - start + 1];
		int i = start, j = mid + 1, cur = 0;
		while (i <= mid && j <= end) {
			long num1 = nums[i], num2 = nums[j];
			if (num1 > 2 * num2) {
				res += mid - i + 1;
				j++;
			} else {
				i++;
			}
		}
		i = start;
		j = mid + 1;
		while (i <= mid && j <= end) {
			if (nums[i] > nums[j]) {
				tmp[cur++] = nums[j++];
			} else {
				tmp[cur++] = nums[i++];
			}
		}
		if (i > mid) {
			while (j <= end) {
				tmp[cur++] = nums[j++];
			}
		} else {
			while (i <= mid) {
				tmp[cur++] = nums[i++];
			}
		}
		for (int k = 0; k < tmp.length; k++) {
			nums[start + k] = tmp[k];
		}
	}
}
