package question.question300_399;

/*
 * Given a nested list of integers represented as a string, implement a parser to deserialize it.
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * Note: You may assume that the string is well-formed:
 * String is non-empty.
 * String does not contain white spaces.
 * String contains only digits 0-9, [, - ,, ].
 * Example 1:
 * Given s = "324",
 * You should return a NestedInteger object which contains a single integer 324.
 * Example 2:
 * Given s = "[123,[456,[789]]]",
 * Return a NestedInteger object containing a nested list with 2 elements:
 * 1. An integer containing value 123.
 * 2. A nested list containing two elements:
 * i.  An integer containing value 456.
 * ii. A nested list with one element:
 * a. An integer containing value 789.
 */
import help.NestedInteger;

//用递归和一个循环就能实现反编译（注意一个NestedInteger可能什么都不包含，那就不要再向其中添加null之类的东西）
//主要就是对于一个NestedInteger内部元素的划分，不能直接用split(",")来做，因为其中还有可能包含NestedInteger（中括号）
public class Question385_own1 {
	public NestedInteger deserialize(String s) {
		if (s.isEmpty())
			return null;
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
				NestedInteger tmp = deserialize(s.substring(start, i));
				if (tmp != null)
					res.add(tmp);
				start = i + 1;
			}
		}
		NestedInteger tmp = deserialize(s.substring(start, s.length() - 1));
		if (tmp != null)
			res.add(tmp);
		return res;
	}
}
