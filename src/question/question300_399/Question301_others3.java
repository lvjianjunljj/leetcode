package question.question300_399;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//如果需要用到这种需要有类似于递归的改变输入参数的BFS，感觉只能是用这种封装内部类的方法了
public class Question301_others3 {
	public List<String> removeInvalidParentheses(String s) {
		if (judge(s))
			return Collections.singletonList(s);
		List<String> res = new ArrayList<String>();
		Queue<Tuple> queue = new LinkedList<Tuple>();
		queue.add(new Tuple(s, 0, ')'));
		while (!queue.isEmpty()) {
			Tuple t = queue.poll();
			for (int i = t.start; i < t.s.length(); i++) {
				if (t.s.charAt(i) != '(' && t.s.charAt(i) != ')')
					continue;
				if (i > t.start && t.s.charAt(i) == t.s.charAt(i - 1))
					continue;
				if (t.remove == '(' && t.s.charAt(i) == ')')
					continue;
				String next = t.s.substring(0, i) + t.s.substring(i + 1);
				if (judge(next))
					res.add(next);
				else if (res.isEmpty())
					queue.add(new Tuple(next, i, t.remove));
			}
		}
		return res;
	}

	private boolean judge(String s) {
		int k = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(')
				k++;
			if (c == ')' && k-- == 0)
				return false;
		}
		return k == 0;
	}

	class Tuple {

		String s;
		int start;
		char remove;

		public Tuple(String s, int start, char remove) {
			this.s = s;
			this.start = start;
			this.remove = remove;
		}
	}
}
