package question.question1_99;

/*
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * Note: Given n will be between 1 and 9 inclusive.
 */
import java.util.ArrayList;
import java.util.List;
//我用最普通的回溯做就超时了，这道题感觉就不能用回溯做
public class Question60_own1 {
	public String getPermutation(int n, int k) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		boolean[] used = new boolean[n];
		dfs(res, used, new ArrayList<Integer>(), 0, n);
		List<Integer> list = res.get(k - 1);
		String result = "";
		for (int i : list)
			result += i;
		return result;
	}

	private void dfs(List<List<Integer>> res, boolean[] used,
			List<Integer> path, int count, int n) {
		if (count == n)
			res.add(new ArrayList<Integer>(path));
		else {
			for (int i = 0; i < n; i++) {
				if (!used[i]) {
					used[i] = true;
					path.add(i + 1);
					dfs(res, used, path, count + 1, n);
					used[i] = false;
					path.remove(path.size() - 1);
				}
			}
		}
	}
}
