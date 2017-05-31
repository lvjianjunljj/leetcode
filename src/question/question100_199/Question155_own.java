package question.question100_199;

/*
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * Example:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 */
import java.util.PriorityQueue;
import java.util.Stack;

//用一个stack就能满足除了min功能的其他要求，然后用一个优先队列满足min的功能。
public class Question155_own {
	Stack<Integer> stack;
	PriorityQueue<Integer> queue;

	/** initialize your data structure here. */
	public Question155_own() {
		stack = new Stack<Integer>();
		queue = new PriorityQueue<Integer>();
	}

	public void push(int x) {
		stack.push(x);
		queue.offer(x);
	}

	public void pop() {
		queue.remove(stack.pop());
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return queue.peek();
	}
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */
