package question.question300_399;

/*
 * Given a data stream input of non-negative integers a1, a2, ..., an, ..., summarize the numbers seen 
 * so far as a list of disjoint intervals.
 * For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the summary will be:
 * [1, 1]
 * [1, 1], [3, 3]
 * [1, 1], [3, 3], [7, 7]
 * [1, 3], [7, 7]
 * [1, 3], [6, 7]
 * Follow up:
 * What if there are lots of merges and the number of disjoint intervals are 
 * small compared to the data stream's size?
 */
import help.Interval;
import java.util.ArrayList;
import java.util.List;

//其实很简单，就是插入的时候用BFS，然后再比较一下就行，再注意一下边界条件就行
//答案列出的方法是用TreeMap做的，一般，没意思
public class Question352_own {

	List<Interval> list;

	/** Initialize your data structure here. */
	public Question352_own() {
		list = new ArrayList<Interval>();
	}

	public void addNum(int val) {
		if (list.isEmpty()) {
			list.add(new Interval(val, val));
			return;
		}
		int i = 0, j = list.size() - 1;
		while (i <= j) {
			int mid = i + (j - i) / 2;
			if (val > list.get(mid).start)
				i = mid + 1;
			else
				j = mid - 1;
		}
		if (i == 0) {
			if (val == list.get(0).start)
				return;
			else if (val == list.get(0).start - 1)
				list.get(0).start = val;
			else
				list.add(0, new Interval(val, val));
		} else if (i == list.size()) {
			if (val <= list.get(list.size() - 1).end)
				return;
			else if (val == list.get(list.size() - 1).end + 1)
				list.get(list.size() - 1).end = val;
			else
				list.add(new Interval(val, val));
		} else {
			if (list.get(i - 1).end + 1 == val && list.get(i).start - 1 == val) {
				int start = list.get(i - 1).start;
				list.remove(i - 1);
				list.get(i - 1).start = start;
			} else if (list.get(i - 1).end + 1 == val)
				list.get(i - 1).end = val;
			else if (list.get(i).start - 1 == val)
				list.get(i).start = val;
			else if (list.get(i - 1).end < val && list.get(i).start > val)
				list.add(i, new Interval(val, val));
		}
	}

	public List<Interval> getIntervals() {
		return list;
	}
}
