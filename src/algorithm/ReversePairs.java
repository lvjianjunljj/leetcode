package algorithm;

/**
 * @author lvjj
 * @date 2017年4月22日 用归并排序找到数组的逆序对
 * 
 */
public class ReversePairs {
	int res = 0;

	public int reversePairs(int[] nums) {
		mergeSort(nums, 0, nums.length - 1);
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
			if (nums[i] > nums[j]) {
				res += mid - i + 1;
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
