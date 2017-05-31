package question.question200_299;

/*
 * Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?
 */
//直接就是类比274做的,耗时相对较长，用binary search做会好很多。
public class Question275_own {
	public int hIndex(int[] citations) {
		int n = citations.length;
		for (int i = 0; i < n; i++) {
			if (citations[n - 1 - i] < i + 1)
				return i;
		}
		return n;
	}
}
