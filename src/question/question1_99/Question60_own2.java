package question.question1_99;

import java.util.ArrayList;
import java.util.List;
//在own1的基础上做了一些优化，降低了空间复杂度，肯定还是超时
public class Question60_own2 {
	int num = 1;
	List<Integer> list = new ArrayList<Integer>();

	public String getPermutation(int n, int k) {
		boolean[] used = new boolean[n];
		dfs(used, new ArrayList<Integer>(), 0, n, k);
		String result = "";
		for (int i : list)
			result += i;
		return result;
	}

	private void dfs(boolean[] used, List<Integer> path, int count, int n, int k) {
		if (num > k)
			return;
		if (num == k)
			list = new ArrayList<Integer>(path);
		if (count == n)
			num++;
		else {
			for (int i = 0; i < n; i++) {
				if (!used[i]) {
					used[i] = true;
					path.add(i + 1);
					dfs(used, path, count + 1, n, k);
					used[i] = false;
					path.remove(path.size() - 1);
				}
			}
		}
	}
}
