package question.question300_399;

import java.util.Stack;
import help.NestedInteger;

//这种题能用递归实现就能用栈实现
public class Question385_others {
	public NestedInteger deserialize(String s) {
		if (s.charAt(0) != '[')
			return new NestedInteger(Integer.valueOf(s));
		NestedInteger cur = null;
		Stack<NestedInteger> stack = new Stack<NestedInteger>();
		int start = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '[') {
				if (cur != null)
					stack.push(cur);
				cur = new NestedInteger();
				start = i + 1;
			} else if (c == ']') {
				String num = s.substring(start, i);
				if (!num.isEmpty())
					cur.add(new NestedInteger(Integer.valueOf(num)));
				if (!stack.isEmpty()) {
					NestedInteger pop = stack.pop();
					pop.add(cur);
					cur = pop;
				}
				start = i + 1;
			} else if (c == ',') {
				if (s.charAt(i - 1) != ']') {
					String num = s.substring(start, i);
					cur.add(new NestedInteger(Integer.valueOf(num)));
				}
				start = i + 1;
			}
		}
		return cur;
	}
}
