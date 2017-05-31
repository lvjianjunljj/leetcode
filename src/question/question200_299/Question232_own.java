package question.question200_299;

import java.util.Stack;

public class Question232_own {
	// 现在stack都封装的很好了，所以这些操作都不需要自己写了
	Stack<Integer> stack = new Stack<Integer>();

	// Push element x to the back of queue.
	public void push(int x) {
		stack.add(x);
	}

	// Removes the element from in front of queue.
	public void pop() {
		stack.remove(0);
	}

	// Get the front element.
	public int peek() {
		return stack.elementAt(0);
	}

	// Return whether the queue is empty.
	public boolean empty() {
		return stack.isEmpty();
	}
}
