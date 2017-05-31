package question.question200_299;

import java.util.Stack;
//用栈来实现，简直是天才
public class Question224_others {
	public int calculate(String s) {
		Stack<Integer> stackInt = new Stack<Integer>();
		Stack<Integer> stackSign = new Stack<Integer>();
		int result = 0, sign = 1, num = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= '0' && c <= '9') {
				int digit = Character.getNumericValue(c);
				if ((Integer.MAX_VALUE - digit) / 10 < num)
					num = Integer.MAX_VALUE;
				else
					num = 10 * num + digit;
			} else if (c == '+' || c == '-') {
				result += num * sign;
				num = 0;
				sign = c == '+' ? 1 : -1;
			} else if (c == '(') {
				stackInt.push(result);
				stackSign.push(sign);
				result = 0;
				sign = 1;
			} else if (c == ')') {
				result += num * sign;
				result = result * stackSign.pop() + stackInt.pop();
				num = 0;
				sign = 1;
			}
		}
		result += num * sign;
		return result;
	}
}
