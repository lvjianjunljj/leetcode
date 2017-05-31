package question.question200_299;

import java.util.ArrayList;
import java.util.List;

//受到79题others的启发精简了一下代码，确实舒心了很多
public class Question212_own3 {
	class TrieNode {
		TrieNode[] children = new TrieNode[26];
		String item = "";
	}

	public List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList<String>();
		TrieNode root = new TrieNode();
		for (String s : words) {
			TrieNode node = root;
			for (int i = 0; i < s.length(); i++) {
				if (node.children[s.charAt(i) - 'a'] == null)
					node.children[s.charAt(i) - 'a'] = new TrieNode();
				node = node.children[s.charAt(i) - 'a'];
			}
			node.item = s;
		}
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[0].length; j++)
				dfs(res, board, root, i, j);
		return res;
	}

	private void dfs(List<String> res, char[][] board, TrieNode node, int i,
			int j) {
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
				|| board[i][j] > 'z')
			return;
		node = node.children[board[i][j] - 'a'];
		if (node == null)
			return;
		if (!node.item.equals("")) {
			res.add(node.item);
			node.item = "";
		}
		board[i][j] += 26;
		dfs(res, board, node, i + 1, j);
		dfs(res, board, node, i, j + 1);
		dfs(res, board, node, i - 1, j);
		dfs(res, board, node, i, j - 1);
		board[i][j] -= 26;
	}
}
