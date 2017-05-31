package question.question1_99;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//维护两个数组来代替own中的判断该path是否可行——回溯的思路都是差不多的
public class Question51_others {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new ArrayList<List<String>>();
		add(0, res, new boolean[n], new boolean[2 * n - 1],
				new boolean[2 * n - 1], new String[n], n);
		return res;
	}

	private void add(int r, List<List<String>> res, boolean[] in,
			boolean[] in1, boolean[] in2, String[] path, int n) {
		if (r == n)
			res.add(new ArrayList<String>(Arrays.asList(path)));
		else {
			char[] list = new char[n];
			Arrays.fill(list, '.');
			for (int i = 0; i < n; i++) {
				if (!in[i] && !in1[r - i + n - 1] && !in2[r + i]) {
					in[i] = true;
					in1[r - i + n - 1] = true;
					in2[r + i] = true;
					list[i] = 'Q';
					path[r] = new String(list);
					add(r + 1, res, in, in1, in2, path, n);
					in[i] = false;
					in1[r - i + n - 1] = false;
					in2[r + i] = false;
					list[i] = '.';
				}
			}
		}
	}
}
