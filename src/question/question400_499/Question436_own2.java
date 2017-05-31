package question.question400_499;

import help.Interval;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

//看了提示才知道要用BFS做，还是非常容易写出来的，就是要注意边界条件的书写——耗时确实还是很低的
public class Question436_own2 {
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
			Interval tmp = search(intervals, i, intervals.length - 1,
					intervals[i].end);
			res[map.get(intervals[i])] = tmp.start >= intervals[i].end ? map
					.get(tmp) : -1;
		}
		return res;
	}

	private Interval search(Interval[] intervals, int i, int j, int target) {
		if (i >= j) {
			return intervals[i];
		}
		int mid = (i + j) / 2;
		if (intervals[mid].start == target) {
			return intervals[mid];
		} else if (intervals[mid].start > target) {
			return search(intervals, i, mid, target);
		} else {
			return search(intervals, mid + 1, j, target);
		}
	}
}
