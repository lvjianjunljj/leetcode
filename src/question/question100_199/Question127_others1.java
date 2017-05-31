package question.question100_199;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
//受到答案的启发写出的这个方法，用队列实现比答案直接用数组实现要好一些，还是比较不容易的
//在这个方法里我封装的方法并没有这里的三层循环的耗时短。
public class Question127_others1 {
	public int ladderLength(String beginWord, String endWord,
			Set<String> wordList) {
		Queue<String> queue = new LinkedList<String>();
		queue.add(beginWord);
		wordList.add(endWord);
		int dis = 1;
		while (queue.size() != 0) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String word = queue.poll();
				if (word.equals(endWord))
					return dis;
				for (int j = 0; j < word.length(); j++) {
					char[] array = word.toCharArray();
					for (int k = 'a'; k <= 'z'; k++) {
						array[j] = (char) k;
						if (wordList.contains(new String(array))) {
							queue.add(new String(array));
							wordList.remove(new String(array));
						}
					}
				}
			}
			dis++;
		}
		return 0;
	}
}
