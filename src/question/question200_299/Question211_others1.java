package question.question200_299;

/*
 * Design a data structure that supports the following two operations:
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
 * For example:
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 */
//需要自己封装字典树TrieNode——将word的每一位记录在路径中，而item则记录这条路的到该点是否是尽头——所以针对本题可以有改进
public class Question211_others1 {
	private class TrieNode {
		//在这里对于字典树不需要有构造方法
		TrieNode[] children = new TrieNode[26];
		String item = "";
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
		node.item = word;
	}

	public boolean search(String word) {
		return search(word.toCharArray(), 0, root);
	}

	private boolean search(char[] array, int k, TrieNode node) {
		if (k == array.length)
			return !node.item.equals("");
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
