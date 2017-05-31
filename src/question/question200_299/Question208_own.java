package question.question200_299;

/*
 * Implement a trie with insert, search, and startsWith methods.
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 */
//就是维护一个字典树，之前做过的211和212都是通过字典树实现的——写得还算是溜（晚上方法都大同小异，没什么意思）
public class Question208_own {
	class TrieNode {
		// 不需要有构造方法（children在新建TrieNode时都是null）
		TrieNode[] children = new TrieNode[26];
		String word = "";

		// Initialize your data structure here.
		public TrieNode() {
		}
	}

	public class Trie {
		private TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		// Inserts a word into the trie.
		public void insert(String word) {
			TrieNode cur = root;
			for (int i = 0; i < word.length(); i++) {
				if (cur.children[word.charAt(i) - 'a'] == null)
					cur.children[word.charAt(i) - 'a'] = new TrieNode();
				cur = cur.children[word.charAt(i) - 'a'];
			}
			cur.word = word;
		}

		// Returns if the word is in the trie.
		public boolean search(String word) {
			TrieNode cur = root;
			for (int i = 0; i < word.length(); i++) {
				if (cur.children[word.charAt(i) - 'a'] == null)
					return false;
				cur = cur.children[word.charAt(i) - 'a'];
			}
			return cur.word != "";
		}

		// Returns if there is any word in the trie
		// that starts with the given prefix.
		public boolean startsWith(String prefix) {
			TrieNode cur = root;
			for (int i = 0; i < prefix.length(); i++) {
				if (cur.children[prefix.charAt(i) - 'a'] == null)
					return false;
				cur = cur.children[prefix.charAt(i) - 'a'];
			}
			return true;
		}
	}

	// Your Trie object will be instantiated and called as such:
	// Trie trie = new Trie();
	// trie.insert("somestring");
	// trie.search("key");
}
