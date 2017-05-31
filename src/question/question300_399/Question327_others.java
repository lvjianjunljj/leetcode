package question.question300_399;

//就这中方法，我跪了——在归并排序的过程中将结果求出来——
//如果想要排序就只能用归并排序——再进行排序前排序数组mid左边的数和mid右边的数相对位置在原数组中本身也在mid左边和mid右边
//所以右边的数减左边的数一定对应某串数的和
//同时也要熟练掌握这种归并排序的实现方法。
public class Question327_others {
	public int countRangeSum(int[] nums, int lower, int upper) {
		int n = nums.length;
		if (n < 1)
			return 0;
		long[] sums = new long[n + 1];
		for (int i = 1; i < n + 1; i++)
			sums[i] = sums[i - 1] + nums[i - 1];
		return aux(sums, 0, n + 1, lower, upper);
	}

	private int aux(long[] sums, int start, int end, int lower, int upper) {
		if (end - start < 2)
			return 0;
		int mid = (start + end) / 2;
		int count = aux(sums, start, mid, lower, upper)
				+ aux(sums, mid, end, lower, upper);
		int j = mid, k = mid, t = mid, r = 0;
		long[] cache = new long[end - start];
		for (int i = start; i < mid; i++) {
			while (j < end && sums[j] - sums[i] < lower)
				j++;
			while (k < end && sums[k] - sums[i] <= upper)
				k++;
			while (t < end && sums[t] < sums[i])
				cache[r++] = sums[t++];
			cache[r++] = sums[i];
			count += k - j;
		}
		System.arraycopy(cache, 0, sums, start, t - start);
		return count;
	}
}
