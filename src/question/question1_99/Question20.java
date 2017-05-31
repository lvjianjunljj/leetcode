package question.question1_99;

import java.util.Stack;
/*
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class Question20 {
	public boolean isValid(String s) {
		// 这种对应关系应该用栈做
		char[] list = s.toCharArray();
		char a1 = "(".toCharArray()[0];
		char a2 = ")".toCharArray()[0];
		char b1 = "[".toCharArray()[0];
		char b2 = "]".toCharArray()[0];
		char c1 = "{".toCharArray()[0];
		char c2 = "}".toCharArray()[0];
		int n = list.length;
		Stack stack = new Stack();
		if (n % 2 == 1) {
			return false;
		}
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == a1 || s.charAt(i) == b1 || s.charAt(i) == c1) {
				stack.add(s.charAt(i));
			} else if (stack.isEmpty()) {
				return false;
			} else {
				char comp = (Character) stack.pop();
				if ((s.charAt(i) == a2 && comp != a1)
						|| (s.charAt(i) == b2 && comp != b1)
						|| (s.charAt(i) == c2 && comp != c1)) {
					return false;
				}
			}
		}
		if (!stack.isEmpty()) {
			return false;
		}
		return true;
	}
}
