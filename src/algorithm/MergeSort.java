package algorithm;

//要熟练掌握这种归并排序的实现方法
public class MergeSort {
	public static void main(String[] args) {
		long[] a = new long[] { 1, 2, 3, 4, 56, 71, 2, 3, 4, 5, 6, 6 };
		mergeSort(a, 0, a.length);
		for (long i : a)
			System.out.println(i);
	}

	private static void mergeSort(long[] sums, int start, int end) {
		if (end - start < 2)
			return;
		int mid = (start + end) / 2;
		mergeSort(sums, start, mid);
		mergeSort(sums, mid, end);
		int t = mid, r = 0;
		long[] cache = new long[end - start];
		for (int i = start; i < mid; i++) {
			while (t < end && sums[i] > sums[t])
				cache[r++] = sums[t++];
			cache[r++] = sums[i];
		}
		// 注意这个方法！！！
		System.arraycopy(cache, 0, sums, start, r);
	}
}
