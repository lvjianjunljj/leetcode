package question.question1_99;

import java.util.ArrayList;
import java.util.List;

/*
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 */
public class Question77_quickest {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> combs = new ArrayList<List<Integer>>();
		int[] comb = new int[n + 1];
		Combine(combs, comb, 0, 1, n, k);
		return combs;
	}

	private void Combine(List<List<Integer>> combs, int[] comb, int size,
			int start, int n, int k) {
		if (k == 0) {
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < size; i++) {
				list.add(comb[i]);
			}
			combs.add(list);
			return;
		}
		for (int i = start; i <= n; i++) {
			comb[size++] = i;
			Combine(combs, comb, size, i + 1, n, k - 1);
			comb[size--] = i;
		}
	}
}
a