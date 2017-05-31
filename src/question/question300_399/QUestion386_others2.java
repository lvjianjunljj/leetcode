package question.question300_399;

import java.util.ArrayList;
import java.util.List;

//用递归实现的话逻辑看起来简洁一些，判断少一些
public class QUestion386_others2 {
	public List<Integer> lexicalOrder(int n) {
		List<Integer> res = new ArrayList<Integer>();
		for (int i = 1; i < 10; i++)
			dfs(i, n, res);
		return res;
	}

	private void dfs(int i, int n, List<Integer> res) {
		if (i > n)
			return;
		res.add(i);
		for (int j = 0; j < 10; j++) {
			if (i * 10 + j > n)
				break;
			dfs(i * 10 + j, n, res);
		}
	}
}
