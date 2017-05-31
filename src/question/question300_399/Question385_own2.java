package question.question300_399;

import help.NestedInteger;

//一开始就说s不为空，所以在for循环里加个判断更为简洁——其中一种答案和我的思路基本一致
public class Question385_own2 {
	public NestedInteger deserialize(String s) {
		if (s.charAt(0) != '[')
			return new NestedInteger(Integer.parseInt(s));
		NestedInteger res = new NestedInteger();
		int k = 0, start = 1;
		for (int i = 1; i < s.length() - 1; i++) {
			if (s.charAt(i) == '[')
				k++;
			else if (s.charAt(i) == ']')
				k--;
			else if (k == 0 && s.charAt(i) == ',') {
				if (start < i)
					res.add(deserialize(s.substring(start, i)));
				start = i + 1;
			}
		}
		if (start < s.length() - 1)
			res.add(deserialize(s.substring(start, s.length() - 1)));
		return res;
	}
}
