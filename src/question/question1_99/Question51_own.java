package question.question1_99;

/*
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that 
 * no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement, 
 * where 'Q' and '.' both indicate a queen and an empty space respectively.
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 * [
 * [".Q..",  // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * ["..Q.",  // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 */
import java.util.ArrayList;
import java.util.List;

//其实这道题并不是很难，用回溯一层一层向下走，然后到每一层的时候判断该层是否和上面某一层冲突就行
//之前的n-1层不用重复判断了，同时维护一个index数组用于判断
public class Question51_own {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new ArrayList<List<String>>();
		List<char[]> path = new ArrayList<char[]>();
		for (int i = 0; i < n; i++) {
			char[] tmp = new char[n];
			for (int j = 0; j < n; j++)
				tmp[j] = '.';
			path.add(tmp);
		}
		int[] index = new int[n];
		add(res, path, index, 0, n);
		return res;
	}

	private void add(List<List<String>> res, List<char[]> path, int[] index,
			int high, int n) {
		if (high == n && judge(index, high)) {
			List<String> tmp = new ArrayList<String>();
			for (char[] c : path)
				tmp.add(new String(c));
			res.add(tmp);
		}
		if (high >= n)
			return;
		for (int i = 0; i < n; i++) {
			path.get(high)[i] = 'Q';
			index[high] = i;
			if (high == 0 || judge(index, high))
				add(res, path, index, high + 1, n);
			path.get(high)[i] = '.';
		}
	}

	private boolean judge(int[] index, int high) {
		int in = index[high - 1];
		for (int i = high - 2; i >= 0; i--)
			if (in == index[i] || high - 1 - i == Math.abs(in - index[i]))
				return false;
		return true;
	}
}
