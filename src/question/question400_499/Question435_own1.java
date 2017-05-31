package question.question400_499;
/*
 * Given a collection of intervals, find the minimum number of intervals you need to remove to 
 * make the rest of the intervals non-overlapping.
 * Note:
 * You may assume the interval's end point is always bigger than its start point.
 * Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
 * Example 1:
 * Input: [ [1,2], [2,3], [3,4], [1,3] ]
 * Output: 1
 * Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
 * Example 2:
 * Input: [ [1,2], [1,2], [1,2] ]
 * Output: 2
 * Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
 * Example 3:
 * Input: [ [1,2], [2,3] ]
 * Output: 0
 * Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import help.Interval;

//排序完了以后这道题就简单了，用贪心就能做，对于前k个已经完成的加入k+1个时只要比较k和k+1是否重合
//如果有则必须去除一个并使得剩下的k个的end的最大值尽量小，即k和k+1个留下一个end较小的
public class Question435_own1 {
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
		Stack<Interval> stack = new Stack<Interval>();
		int count = 0;
		for (int i = 0; i < intervals.length; i++) {
			if (stack.isEmpty()) {
				stack.push(intervals[i]);
			} else {
				if (stack.peek().end > intervals[i].start) {
					count++;
					if (stack.peek().end > intervals[i].end) {
						stack.pop();
						stack.push(intervals[i]);
					}
				} else {
					stack.push(intervals[i]);
				}
			}
		}
		return count;
	}
}
