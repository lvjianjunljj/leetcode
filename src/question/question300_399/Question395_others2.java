package question.question300_399;

import java.util.ArrayList;
import java.util.List;

//根据others1的思路进行改进，一次递归将每一个不符合的点都挑出来，然后将每一段做递归取其最大值
//因为测试数据的原因，并没有降低耗时反而升高了一点
public class Question395_others2 {
	public int longestSubstring(String s, int k) {
		char[] list = s.toCharArray();
		return aux(list, 0, list.length, k);
	}

	private int aux(char[] list, int start, int end, int k) {
		if (end - start < k)
			return 0;
		List<Integer> cut = new ArrayList<Integer>();
		char[] alp = new char[26];
		for (int i = start; i < end; i++)
			alp[list[i] - 'a']++;
		for (int i = start; i < end; i++) {
			if (alp[list[i] - 'a'] == 0)
				continue;
			if (alp[list[i] - 'a'] < k)
				cut.add(i);
		}
		if (cut.size() == 0)
			return end - start;
		int res = Math.max(aux(list, start, cut.get(0), k), aux(list, cut
				.get(cut.size() - 1) + 1, end, k));
		for (int i = 1; i < cut.size(); i++)
			res = Math.max(res, aux(list, cut.get(i - 1) + 1, cut.get(i), k));
		return res;
	}
}
