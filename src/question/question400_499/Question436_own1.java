package question.question400_499;

/*
 * Given a set of intervals, for each of the interval i, check if there exists an interval j 
 * whose start point is bigger than or equal to the end point of the interval i, 
 * which can be called that j is on the "right" of i.
 * For any interval i, you need to store the minimum interval j's index, 
 * which means that the interval j has the minimum start point to build the "right" relationship for interval i. 
 * If the interval j doesn't exist, store -1 for the interval i. 
 * Finally, you need output the stored value of each interval as an array.
 * Note:
 * You may assume the interval's end point is always bigger than its start point.
 * You may assume none of these intervals have the same start point.
 * Example 1:
 * Input: [ [1,2] ]
 * Output: [-1]
 * Explanation: There is only one interval in the collection, so it outputs -1.
 * Example 2:
 * Input: [ [3,4], [2,3], [1,2] ]
 * Output: [-1, 0, 1]
 * Explanation: There is no satisfied "right" interval for [3,4].
 * For [2,3], the interval [3,4] has minimum-"right" start point;
 * For [1,2], the interval [2,3] has minimum-"right" start point.
 * Example 3:
 * Input: [ [1,4], [2,3], [3,4] ]
 * Output: [-1, 2, -1]
 * Explanation: There is no satisfied "right" interval for [1,4] and [3,4].
 * For [2,3], the interval [3,4] has minimum-"right" start point.
 */
import help.Interval;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

//直接两层循环暴力破解肯定是超时的，排序完以后还是两层循环，耗时高但至少AC了
public class Question436_own1 {
	public int[] findRightInterval(Interval[] intervals) {
		HashMap<Interval, Integer> map = new HashMap<Interval, Integer>();
		for (int i = 0; i < intervals.length; i++) {
			map.put(intervals[i], i);
		}
		Comparator<Interval> c = new Comparator<Interval>() {
			@Override
			public int compare(Interval i1, Interval i2) {
				if (i1.start > i2.start) {
					return 1;
				} else if (i1.start < i2.start) {
					return -1;
				} else {
					return 0;
				}
			}
		};
		Arrays.sort(intervals, c);
		int[] res = new int[intervals.length];
		for (int i = 0; i < intervals.length; i++) {
			res[map.get(intervals[i])] = -1;
			int end = intervals[i].end;
			for (int j = i + 1; j < intervals.length; j++) {
				if (end <= intervals[j].start) {
					res[map.get(intervals[i])] = map.get(intervals[j]);
					break;
				}
			}
		}
		return res;
	}
}
