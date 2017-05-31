package question.question100_199;

import java.util.Stack;

//用一个栈就能实现也比较巧妙，入栈的时候和出栈的时候分别维护min，而栈中存的也是每个数与之前的min的差值——美妙啊
public class Question155_others1 {
	Stack<Long> stack;
	long min;

	/** initialize your data structure here. */
	public Question155_others1() {
		stack = new Stack<Long>();
		min = 0;
	}

	public void push(int x) {
		if (stack.isEmpty()) {
			min = x;
			stack.push(0L);
		} else {
			stack.push(x - min);
			min = Math.min(x, min);
		}
	}

	public void pop() {
		if (stack.isEmpty())
			return;
		long pop = stack.pop();
		if (pop < 0)
			min -= pop;
	}

	public int top() {
		long top = stack.peek();
		if (top < 0)
			return (int) min;
		else
			return (int) (min + top);
	}

	public int getMin() {
		return (int) min;
	}
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */
