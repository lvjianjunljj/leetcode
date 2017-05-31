package question.question400_499;

import java.util.Arrays;
import java.util.Comparator;
import help.Interval;

//其实完全没必要维护一个stack，只要用一个Interval维护一个last就行，因为每次也是第i个和最后一个进行比较就行
public class Question435_own2 {
	public int eraseOverlapIntervals(Interval[] intervals) {
		Comparator<Interval> c = new Comparator<Interval>() {
			@Override
			public int compare(Interval i1, Interval i2) {
				if (i1.start > i2.start) {
					return 1;
				} else if (i1.start < i2.start) {
					return -1;
				} else {
					return i1.end - i2.end;
				}
			}
		};
		Arrays.sort(intervals, c);
		int count = 0;
		Interval last = null;
		for (int i = 0; i < intervals.length; i++) {
			if (last == null) {
				last = intervals[i];
			} else {
				if (last.end > intervals[i].start) {
					count++;
					if (last.end > intervals[i].end) {
						last = intervals[i];
					}
				} else {
					last = intervals[i];
				}
			}
		}
		return count;
	}
}
