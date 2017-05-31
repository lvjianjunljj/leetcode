package question.question100_199;

/*
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the word list
 * For example,
 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * Return
 [
 ["hit","hot","dot","dog","cog"],
 ["hit","hot","lot","log","cog"]
 ]
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
//用了dfs，和question126的wordladder1的bfs不同，但是耗时较长，超时了。
public class Question126_own {
	int step = Integer.MAX_VALUE;

	public List<List<String>> findLadders(String beginWord, String endWord,
			Set<String> wordList) {
		if (wordList.contains(beginWord))
			wordList.remove(beginWord);
		List<List<String>> res = new ArrayList<List<String>>();
		List<String> words = new ArrayList<String>();
		words.add(beginWord);
		wordList.add(endWord);
		dfs(res, beginWord, new ArrayList<String>(), wordList, endWord, 1);
		int size = res.size();
		int j = 0;
		for (int i = 0; i < size; i++) {
			if (res.get(j).size() > step)
				res.remove(j);
			else
				j++;
		}
		return res;
	}

	private void dfs(List<List<String>> res, String beginWord,
			List<String> path, Set<String> wordList, String endWord, int index) {
		if (index > step)
			return;
		path.add(beginWord);
		if (beginWord.equals(endWord)) {
			res.add(new ArrayList<String>(path));
			path.remove(beginWord);
			step = index;
		}
		for (int i = 0; i < beginWord.length(); i++) {
			char[] array = beginWord.toCharArray();
			for (int j = 'a'; j <= 'z'; j++) {
				array[i] = (char) j;
				if (wordList.contains(new String(array))) {
					wordList.remove(new String(array));
					dfs(res, new String(array), path, wordList, endWord,
							index + 1);
					wordList.add(new String(array));
				}
			}
		}
		path.remove(beginWord);
	}
}
