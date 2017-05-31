package question.question200_299;

/*
 * Implement the following operations of a stack using queues.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * Notes:
 * You must use only standard operations of a queue -- which means only push to back, 
 * peek/pop from front, size, and is empty operations are valid.
 * Depending on your language, queue may not be supported natively. 
 * You may simulate a queue by using a list or deque (double-ended queue), 
 * as long as you use only standard operations of a queue.
 * You may assume that all operations are valid 
 * (for example, no pop or top operations will be called on an empty stack).
 */
import java.util.LinkedList;
import java.util.Queue;

//不能像stack->queue一样一次全部取出到另一个s2，pop()的时候只要s2不为空就一直在s2中pop就行
//这里每次调用pop方法就只能全部取出找到最后一个了，奕玮来回取出放置不会改变数组的顺序
public class Question225_own {
	Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();

	// Push element x onto stack.
	public void push(int x) {
		if (q1.isEmpty())
			q2.add(x);
		else
			q1.add(x);
	}

	// Removes the element on top of the stack.
	public void pop() {
		if (q1.isEmpty()) {
			q1 = q2;
			q2 = new LinkedList<Integer>();
		}
		while (q1.size() > 1)
			q2.add(q1.poll());
		q1.poll();
	}

	// Get the top element.
	public int top() {
		if (q1.isEmpty()) {
			q1 = q2;
			q2 = new LinkedList<Integer>();
		}
		while (q1.size() > 1)
			q2.add(q1.poll());
		int res = q1.poll();
		q2.add(res);
		return res;
	}

	// Return whether the stack is empty.
	public boolean empty() {
		return q1.isEmpty() && q2.isEmpty();
	}
}
