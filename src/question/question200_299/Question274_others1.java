package question.question200_299;

import java.util.Arrays;
//排完序以后用275中的binary search方法做确实可以减少耗时。
public class Question274_others1 {
	public int hIndex(int[] citations) {
		Arrays.sort(citations);
		int len = citations.length;
		int lo = 0, hi = len - 1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (citations[mid] == len - mid)
				return len - mid;
			else if (citations[mid] < len - mid)
				lo = mid + 1;
			else
				hi = mid - 1;
		}
		return len - lo;
	}
}
