package question.question1_99;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
//使用Collections.sort直接对List进行排序，是降低了空间复杂度但增加了耗时
public class Question56_others {
	public List<Interval3> merge(List<Interval3> intervals) {
		Comparator<Interval3> c = new Comparator<Interval3>() {
			public int compare(Interval3 o1, Interval3 o2) {
				if (o1.start > o2.start)
					return 1;
				else if (o1.start < o2.start)
					return -1;
				else
					return 0;
			}
		};
		List<Interval3> res = new ArrayList<Interval3>();
		if (intervals.size() == 0)
			return res;
		Collections.sort(intervals, c);
		Interval3 cur = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			if (intervals.get(i).start > cur.end) {
				res.add(cur);
				cur = intervals.get(i);
			} else
				cur.end = Math.max(cur.end, intervals.get(i).end);
		}
		res.add(cur);
		return res;
	}
}
class Interval3 {
	int start;
	int end;

	Interval3() {
		start = 0;
		end = 0;
	}

	Interval3(int s, int e) {
		start = s;
		end = e;
	}
}
