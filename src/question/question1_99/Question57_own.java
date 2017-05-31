package question.question1_99;
/*
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 */
import java.util.ArrayList;
import java.util.List;
//思路还是非常清晰的，就是需要维护一个mark属性来判断是否已经进入newInterval。
//但是我的方法无法将newInterval在所有区间的后面这种情况囊括，所以需要有最后一个判断。
public class Question57_own {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> result = new ArrayList<Interval>();
		int mark = 1;
		for (Interval cur : intervals) {
			if (cur.end < newInterval.start || mark == 3) {
				result.add(cur);
			} else if (mark == 1) {
				if (newInterval.end >= cur.start) {
					Interval inter = new Interval(Math.min(cur.start,
							newInterval.start), Math.max(cur.end,
							newInterval.end));
					result.add(inter);
					mark = 2;
				} else {
					result.add(newInterval);
					result.add(cur);
					mark = 3;
				}
			} else {
				if (cur.start > newInterval.end) {
					result.add(cur);
					mark = 3;
				} else if (cur.end > newInterval.end) {
					result.get(result.size() - 1).end = cur.end;
					mark = 3;
				}
			}
		}
		if (intervals.size() == 0
				|| intervals.get(intervals.size() - 1).end < newInterval.start) {
			result.add(newInterval);
		} else if (intervals.get(intervals.size() - 1).end == newInterval.start) {
			result.get(result.size() - 1).end = newInterval.end;
		}
		return result;
	}
}

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}
