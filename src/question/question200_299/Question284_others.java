package question.question200_299;

import java.util.Iterator;

//答案这种不用多余空间的解法才是比较正统的，维护一个Integer数据类型next来解决这道题
public class Question284_others {
	Iterator<Integer> iterator;
	Integer next;

	public Question284_others(Iterator<Integer> iterator) {
		// initialize any member here.
		this.iterator = iterator;
		next = iterator.hasNext() ? iterator.next() : null;

	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	public Integer next() {
		Integer res = next;
		next = iterator.hasNext() ? iterator.next() : null;
		return res;
	}

	public boolean hasNext() {
		return next != null;
	}
}
