package question.question300_399;

import help.NestedInteger;
import java.util.List;
import java.util.Stack;

//其实这道题用栈做也是正统方法
public class Question341_others {

	Stack<NestedInteger> stack = new Stack<NestedInteger>();

	public Question341_others(List<NestedInteger> nestedList) {
		for (int i = nestedList.size() - 1; i >= 0; i--)
			stack.push(nestedList.get(i));
	}

	public Integer next() {
		return stack.pop().getInteger();
	}

	public boolean hasNext() {
		while (!stack.isEmpty()) {
			NestedInteger cur = stack.peek();
			if (cur.isInteger())
				return true;
			List<NestedInteger> nests = stack.pop().getList();
			for (int i = nests.size() - 1; i >= 0; i--)
				stack.push(nests.get(i));
		}
		return false;
	}
}
