package question.question200_299;

import java.util.Comparator;
import java.util.PriorityQueue;
//想法和others1是一样的，只不过修改了small的排列方式，思想是一样的
public class Question295_others2 {
	// private PriorityQueue<Integer> large = new PriorityQueue<Integer>(
	// new Comparator<Integer>() {
	// public int compare(Integer o1, Integer o2) {
	// return o1.compareTo(o2);
	// }
	// });
	//
	// private PriorityQueue<Integer> small = new PriorityQueue<Integer>(
	// new Comparator<Integer>() {
	// public int compare(Integer o1, Integer o2) {
	// return o2.compareTo(o1);
	// }
	// });
	//
	// // Adds a number into the data structure.
	// public void addNum(int num) {
	// large.offer(num);
	// small.offer(large.poll());
	// if (small.size() > large.size())
	// large.offer(small.poll());
	// }
	//
	// // Returns the median of current data stream
	// public double findMedian() {
	// return large.size() > small.size() ? (double) large.peek() : (large
	// .peek() + small.peek()) / 2.0;
	// }
}
