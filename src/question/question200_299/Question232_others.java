package question.question200_299;

import java.util.Stack;

public class Question232_others {
	// 用两个stack去实现（时间复杂度很高）
	private boolean dataIsInStack1 = true;
	private Stack<Integer> stack1 = new Stack<Integer>();
	private Stack<Integer> stack2 = new Stack<Integer>();

	// Push element x to the back of queue.
	public void push(int x) {
		stack1.push(x);
	}

	// Removes the element from in front of queue.
	public void pop() {
		moveStack(stack1, stack2);
		stack2.pop();
		moveStack(stack2, stack1);
	}

	// Get the front element.
	public int peek() {
		moveStack(stack1, stack2);
		int first = stack2.peek();
		moveStack(stack2, stack1);
		return first;
	}

	// Return whether the queue is empty.
	public boolean empty() {
		return stack1.isEmpty();
	}

	private void moveStack(Stack<Integer> sFrom, Stack<Integer> sTo) {
		while (!sFrom.empty()) {
			sTo.push(sFrom.pop());
		}
	}
}
