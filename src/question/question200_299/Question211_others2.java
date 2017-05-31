package question.question200_299;
//针对others1进行的些许改动，稍微降低了一点耗时
public class Question211_others2 {
	private class TrieNode {
		TrieNode[] children = new TrieNode[26];
		boolean item = false;
	}

	private TrieNode root = new TrieNode();

	public void addWord(String word) {
		char[] list = word.toCharArray();
		TrieNode node = root;
		for (int i = 0; i < list.length; i++) {
			if (node.children[list[i] - 'a'] == null)
				node.children[list[i] - 'a'] = new TrieNode();
			node = node.children[list[i] - 'a'];
		}
		node.item = true;
	}

	public boolean search(String word) {
		return search(word.toCharArray(), 0, root);
	}

	private boolean search(char[] array, int k, TrieNode node) {
		if (k == array.length)
			return node.item;
		if (array[k] != '.' && node.children[array[k] - 'a'] != null)
			return search(array, k + 1, node.children[array[k] - 'a']);
		else if (array[k] == '.')
			for (int i = 0; i < 26; i++)
				if (node.children[i] != null
						&& search(array, k + 1, node.children[i]))
					return true;
		return false;
	}
}
