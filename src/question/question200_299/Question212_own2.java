package question.question200_299;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
//看来对于这种需要查询String的题要用字典树去维护它
//一位一位地查询，当发现该位在字典中没有对应的String时就可以直接返回了
public class Question212_own2 {
	class TrieNode {
		TrieNode[] children = new TrieNode[26];
		String item = "";
	}

	TrieNode root = new TrieNode();

	public List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList<String>();
		int m = board.length;
		if (m == 0)
			return res;
		int n = board[0].length;
		boolean[][] used = new boolean[m + 2][n + 2];
		for (int i = 0; i < m + 2; i++)
			used[i][0] = used[i][n + 1] = true;
		for (int i = 0; i < n + 2; i++)
			used[0][i] = used[m + 1][i] = true;
		for (String s : words) {
			TrieNode node = root;
			for (int i = 0; i < s.length(); i++) {
				if (node.children[s.charAt(i) - 'a'] == null)
					node.children[s.charAt(i) - 'a'] = new TrieNode();
				node = node.children[s.charAt(i) - 'a'];
			}
			node.item = s;
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				used[i + 1][j + 1] = true;
				dfs(res, board, root, used, i, j);
				used[i + 1][j + 1] = false;
			}
		}
		return res;
	}

	private void dfs(List<String> res, char[][] board, TrieNode node,
			boolean[][] used, int i, int j) {
		node = node.children[board[i][j] - 'a'];
		if (node == null)
			return;
		if (!node.item.equals("")) {
			res.add(node.item);
			node.item = "";
		}
		if (!used[i + 2][j + 1]) {
			used[i + 2][j + 1] = true;
			dfs(res, board, node, used, i + 1, j);
			used[i + 2][j + 1] = false;
		}
		if (!used[i + 1][j + 2]) {
			used[i + 1][j + 2] = true;
			dfs(res, board, node, used, i, j + 1);
			used[i + 1][j + 2] = false;
		}
		if (!used[i][j + 1]) {
			used[i][j + 1] = true;
			dfs(res, board, node, used, i - 1, j);
			used[i][j + 1] = false;
		}
		if (!used[i + 1][j]) {
			used[i + 1][j] = true;
			dfs(res, board, node, used, i, j - 1);
			used[i + 1][j] = false;
		}
	}
}
