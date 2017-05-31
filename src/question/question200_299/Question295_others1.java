package question.question200_299;

/*
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
 *  Examples: 
 *  [2,3,4] , the median is 3
 *  [2,3], the median is (2 + 3) / 2 = 2.5
 *  Design a data structure that supports the following two operations:
 *  void addNum(int num) - Add a integer number from the data stream to the data structure.
 *  double findMedian() - Return the median of all elements so far.
 *  For example:
 *  add(1)
 *  add(2)
 *  findMedian() -> 1.5
 *  add(3) 
 *  findMedian() -> 2
 */
import java.util.PriorityQueue;
//对于这种用优先队列封装一大一下的方法
//必须先将输入的数放到large中，然后再将large中的最小数放到small然后再比较两者的长度再进行下一步操作
//这样才能将所有的输入均匀地放到两个优先队列中
public class Question295_others1 {
	private PriorityQueue<Long> large = new PriorityQueue<Long>(),
			small = new PriorityQueue<Long>();

	// Adds a number into the data structure.
	public void addNum(int num) {
		large.offer((long) num);
		small.offer(-large.poll());
		if (large.size() < small.size())
			large.offer(-small.poll());
	}

	// Returns the median of current data stream
	public double findMedian() {
		return large.size() > small.size() ? large.peek()
				: (large.peek() - small.peek()) / 2.0;
	}
}
