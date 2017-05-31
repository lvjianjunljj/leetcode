package question.question300_399;

import java.util.HashSet;

//其实一开始出这个题说不定是想让大家用回溯做，可是耗时确实很高啊
public class Question357_own2 {

	int count = 0;

	public int countNumbersWithUniqueDigits(int n) {
		dfs(new HashSet<Integer>(), n);
		return count;
	}

	private void dfs(HashSet<Integer> path, int n) {
		if (path.size() > n || (path.size() == 1 && path.contains(0)))
			return;
		count++;
		for (int i = 0; i < 10; i++) {
			if (!path.contains(i)) {
				path.add(i);
				dfs(path, n);
				path.remove(i);
			}
		}
	}
}
