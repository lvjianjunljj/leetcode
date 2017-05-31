package question.question200_299;

/*
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 * For example,
 * Given words = ["oath","pea","eat","rain"] and board =
 [
 ['o','a','a','n'],
 ['e','t','a','e'],
 ['i','h','k','r'],
 ['i','f','l','v']
 ]
 Return ["eat","oath"].
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
//仅仅用HashSet<String>去维护字典然后用回溯做这道题是不够的——超时，看来对于这种需要查询String的题要用字典树去维护它
//一位一位地查询，当发现该位在字典中没有对应的String时就可以直接返回了
//除了用字典树去维护字典之外，剩下的思路和79题是一样的
public class Question212_own1 {
	public List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList<String>();
		int m = board.length;
		if (m == 0)
			return res;
		int n = board[0].length;
		int len = 0;
		boolean[][] used = new boolean[m + 2][n + 2];
		for (int i = 0; i < m + 2; i++)
			used[i][0] = used[i][n + 1] = true;
		for (int i = 0; i < n + 2; i++)
			used[0][i] = used[m + 1][i] = true;
		HashSet<String> set = new HashSet<String>();
		for (String s : words) {
			set.add(s);
			len = Math.max(len, s.length());
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				used[i + 1][j + 1] = true;
				dfs(res, board, set, used, new StringBuilder(board[i][j] + ""),
						i, j, len);
				used[i + 1][j + 1] = false;
			}
		}
		return res;
	}

	private void dfs(List<String> res, char[][] board, HashSet<String> set,
			boolean[][] used, StringBuilder path, int i, int j, int len) {
		if (path.length() > len)
			return;
		if (set.contains(path.toString())) {
			set.remove(path.toString());
			res.add(new StringBuilder(path).toString());
		}
		if (!used[i + 2][j + 1]) {
			used[i + 2][j + 1] = true;
			path.append(board[i + 1][j]);
			dfs(res, board, set, used, path, i + 1, j, len);
			used[i + 2][j + 1] = false;
			path.deleteCharAt(path.length() - 1);
		}
		if (!used[i + 1][j + 2]) {
			used[i + 1][j + 2] = true;
			path.append(board[i][j + 1]);
			dfs(res, board, set, used, path, i, j + 1, len);
			used[i + 1][j + 2] = false;
			path.deleteCharAt(path.length() - 1);
		}
		if (!used[i][j + 1]) {
			used[i][j + 1] = true;
			path.append(board[i - 1][j]);
			dfs(res, board, set, used, path, i - 1, j, len);
			used[i][j + 1] = false;
			path.deleteCharAt(path.length() - 1);
		}
		if (!used[i + 1][j]) {
			used[i + 1][j] = true;
			path.append(board[i][j - 1]);
			dfs(res, board, set, used, path, i, j - 1, len);
			used[i + 1][j] = false;
			path.deleteCharAt(path.length() - 1);
		}
	}
}
