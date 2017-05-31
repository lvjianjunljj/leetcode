package question.question300_399;

/*
 * Given a list of unique words. Find all pairs of distinct indices (i, j) in the given list, 
 * so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
 * Example 1:
 * Given words = ["bat", "tab", "cat"]
 * Return [[0, 1], [1, 0]]
 * The palindromes are ["battab", "tabbat"]
 * Example 2:
 * Given words = ["abcd", "dcba", "lls", "s", "sssll"]
 * Return [[0, 1], [1, 0], [3, 2], [2, 4]]
 * The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//想法还是非常巧妙的，对字典树的维护需要有两个参数index和list分别保存当前对应的word的index和与回文相关的一个index数组
public class Question336_others1 {
	class TrieNode {
		TrieNode[] children;
		int index;
		List<Integer> list;

		public TrieNode() {
			children = new TrieNode[26];
			index = -1;
			list = new ArrayList<Integer>();
		}
	}

	public List<List<Integer>> palindromePairs(String[] words) {
		TrieNode root = new TrieNode();
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for (int i = 0; i < words.length; i++) {
			TrieNode cur = root;
			for (int j = 0; j < words[i].length(); j++) {
				if (cur.children[words[i].charAt(j) - 'a'] == null) {
					cur.children[words[i].charAt(j) - 'a'] = new TrieNode();
				}
				if (isPalindrome(words[i], j, words[i].length() - 1)) {
					cur.list.add(i);
				}
				cur = cur.children[words[i].charAt(j) - 'a'];
			}
			cur.list.add(i);
			cur.index = i;
		}
		for (int i = 0; i < words.length; i++) {
			TrieNode cur = root;
			for (int j = words[i].length() - 1; j >= 0; j--) {
				if (cur.index >= 0 && cur.index != i
						&& isPalindrome(words[i], 0, j)) {
					res.add(Arrays.asList(cur.index, i));
				}

				cur = cur.children[words[i].charAt(j) - 'a'];
				if (cur == null)
					break;
			}
			if (cur != null) {
				for (int j : cur.list) {
					if (i == j)
						continue;
					res.add(Arrays.asList(j, i));
				}
			}
		}
		return res;
	}

	private boolean isPalindrome(String s, int i, int j) {
		while (i < j) {
			if (s.charAt(i++) != s.charAt(j--)) {
				return false;
			}
		}
		return true;
	}
}
