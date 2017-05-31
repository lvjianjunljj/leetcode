package question.question1_99;
/*
 * Given a collection of intervals, merge all overlapping intervals.
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
//如果以start由小到大排序，这道题就变得很简单了。
//Arrays.sort方法不能对List进行排序，所以我只能新建一个Interval2[]类型的数组才能对其使用Arrays.sort对其排序
//其实可以用Collections.sort直接对List进行排序，在others中有实现，但是耗时居然比Arrays.sort要长
//并不知道其内部原理，感觉使用Collections.sort是降低了空间复杂度但增加了耗时
public class Question56_own {
	public List<Interval2> merge(List<Interval2> intervals) {
		Comparator<Interval2> c = new Comparator<Interval2>() {
			public int compare(Interval2 o1, Interval2 o2) {
				if (o1.start > o2.start)
					return 1;
				else if (o1.start < o2.start)
					return -1;
				else
					return 0;
			}
		};
		List<Interval2> res = new ArrayList<Interval2>();
		if (intervals.size() == 0)
			return res;
		Interval2[] intervalss = new Interval2[intervals.size()];
		for (int i = 0; i < intervals.size(); i++)
			intervalss[i] = intervals.get(i);
		Arrays.sort(intervalss, c);
		Interval2 cur = intervalss[0];
		for (int i = 1; i < intervalss.length; i++) {
			if (intervalss[i].start > cur.end) {
				res.add(cur);
				cur = intervalss[i];
			} else
				cur.end = Math.max(cur.end, intervalss[i].end);
		}
		res.add(cur);
		return res;
	}
}

class Interval2 {
	int start;
	int end;

	Interval2() {
		start = 0;
		end = 0;
	}

	Interval2(int s, int e) {
		start = s;
		end = e;
	}
}
