package algorithm;

//基数排序，熟悉一下
public class RadixSort {
	public static void main(String[] args) {
		int[] nums = { 2, 1, 4, 5, 1, 11, 11, 16, 22, 13, 245, 1236 };
		radixSort(nums);
		for (int i : nums)
			System.out.print(i + "\t");
	}

	public static void radixSort(int[] nums) {
		int n = nums.length;
		if (n < 2)
			return;
		int m = Integer.MIN_VALUE, exp = 1;
		for (int i : nums)
			m = Math.max(m, i);
		int[] tmp = new int[n];
		while (m / exp > 0) {
			int[] count = new int[10];
			for (int i : nums)
				count[i / exp % 10]++;
			for (int i = 1; i < 10; i++)
				count[i] += count[i - 1];
			// 这里一定是从后向前遍历才不会在这次排序中相同的情况下打乱之前的排序顺序
			for (int i = n - 1; i >= 0; i--)
				tmp[--count[nums[i] / exp % 10]] = nums[i];
			for (int i = 0; i < n; i++)
				nums[i] = tmp[i];
			exp *= 10;
		}
	}
}
