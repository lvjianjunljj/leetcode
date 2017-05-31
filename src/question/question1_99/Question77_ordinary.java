package question.question1_99;

import java.util.LinkedList;
import java.util.List;
/*
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 */
public class Question77_ordinary {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> lists = new LinkedList<List<Integer>>();
		combine(n, k, 1, lists, new LinkedList<Integer>());
		return lists;
	}

	public static void combine(int n, int k, int i, List<List<Integer>> lists,
			LinkedList<Integer> list) {
		if (list.size() == k) {
			lists.add((List<Integer>) list.clone());
			return;
		}
		for (int j = i; j <= n; j++) {
			list.addLast(j);
			combine(n, k, j + 1, lists, list);
			list.removeLast();
		}
	}
}
a