package question.question300_399;

/*
 * Given a nested list of integers, implement an iterator to flatten it.
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * Example 1:
 * Given the list [[1,1],2,[1,1]],
 * By calling next repeatedly until hasNext returns false, 
 * the order of elements returned by next should be: [1,1,2,1,1].
 * Example 2:
 * Given the list [1,[4,[6]]],
 * By calling next repeatedly until hasNext returns false,
 * the order of elements returned by next should be: [1,4,6].
 */
import help.NestedInteger;
import java.util.ArrayList;
import java.util.List;

//其实这道题并不是很难
//读懂了NestedInteger接口的API通过一个对归方法很快就能将输入List<NestedInteger>中的所有的数全部取出
//这道题也就做出来（注意一下NestedInteger只包含NestedInteger或者一个Integer，没有List<Integer>）
public class Question341_own {
	List<Integer> list = new ArrayList<Integer>();
	int n = 0;

	public Question341_own(List<NestedInteger> nestedList) {
		for (NestedInteger nest : nestedList)
			add(list, nest);
	}

	private void add(List<Integer> list, NestedInteger nest) {
		if (nest.isInteger())
			list.add(nest.getInteger());
		else
			for (NestedInteger n : nest.getList())
				add(list, n);
	}

	public Integer next() {
		return list.get(n++);
	}

	public boolean hasNext() {
		return n < list.size();
	}
}
