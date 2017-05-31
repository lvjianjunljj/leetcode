package question.question300_399;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//根据others1的思路自己写的方法，耗时远比它低——他每次remove的时候都要用迭代器，感觉这个耗时比较高
public class Question310_own2 {
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		if (n == 1)
			return Collections.singletonList(0);
		ArrayList<Integer>[] matrix = new ArrayList[n];
		for (int i = 0; i < n; i++)
			matrix[i] = new ArrayList<Integer>();
		for (int[] i : edges) {
			matrix[i[0]].add(i[1]);
			matrix[i[1]].add(i[0]);
		}
		List<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < n; i++)
			if (matrix[i].size() == 1)
				res.add(i);
		while (n > 2) {
			n -= res.size();
			List<Integer> newRes = new ArrayList<Integer>();
			for (int i : res) {
				int j = matrix[i].get(0);
				matrix[j].remove(matrix[j].indexOf(i));
				if (matrix[j].size() == 1)
					newRes.add(j);
			}
			res = newRes;
		}
		return res;
	}
}
