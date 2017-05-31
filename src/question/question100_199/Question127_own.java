package question.question100_199;

/*
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the word list
 * For example,
 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 */
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
//这个方法在wordList数据集较大时会报出java.lang.StackOverflowError的错误——HashMap存储溢出
public class Question127_own {
	int res = Integer.MAX_VALUE;

	public int ladderLength(String beginWord, String endWord,
			Set<String> wordList) {
		if (beginWord == endWord)
			return 1;
		HashMap<String, Queue<String>> map = new HashMap<String, Queue<String>>();
		map.put(beginWord, getAdj(beginWord, wordList));
		Queue<String> neighbor = getAdj(endWord, wordList);
		for (String str : wordList)
			map.put(str, getAdj(str, wordList));
		bfs(map, beginWord, endWord, neighbor, 2);
		return res == Integer.MAX_VALUE ? 0 : res;
	}

	private void bfs(HashMap<String, Queue<String>> map, String beginWord,
			String endWord, Queue<String> neighbor, int level) {
		Queue<String> nextWords = map.get(beginWord);
		while (nextWords.size() > 0) {
			String nextWord = nextWords.poll();
			if (nextWord == endWord) {
				res = Math.min(res, level);
				return;
			}
			if (neighbor.contains(nextWord)) {
				res = Math.min(res, level + 1);
				return;
			}
			bfs(map, nextWord, endWord, neighbor, level + 1);
		}
	}

	private Queue<String> getAdj(String beginWord, Set<String> wordList) {
		Queue<String> adj = new LinkedList<String>();
		char[] array = beginWord.toCharArray();
		for (String word : wordList) {
			char[] wordArray = word.toCharArray();
			int j = 0, i = 0;
			if (array.length == wordArray.length) {
				for (char c : array) {
					if (c != wordArray[i]) {
						j++;
					}
					i++;
				}
			}
			if (j == 1) {
				adj.add(word);
			}
		}
		return adj;
	}
}
