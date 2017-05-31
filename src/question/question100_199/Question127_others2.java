package question.question100_199;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
//用两个链表去存储所有的数据，每次都遍历数据量小的链表，确实可以降低耗时
public class Question127_others2 {
	public int ladderLength(String beginWord, String endWord,
			Set<String> wordList) {
		Queue<String> begin = new LinkedList<String>();
		Queue<String> end = new LinkedList<String>();
		begin.add(beginWord);
		end.add(endWord);
		int dis = 1;
		while (begin.size() != 0 && end.size() != 0) {
			if (begin.size() > end.size()) {
				Queue temp = begin;
				begin = end;
				end = temp;
			}
			int size = begin.size();
			for (int i = 0; i < size; i++) {
				String word = begin.poll();
				for (int j = 0; j < word.length(); j++) {
					char[] array = word.toCharArray();
					for (int k = 'a'; k <= 'z'; k++) {
						array[j] = (char) k;
						if (end.contains(new String(array)))
							return dis + 1;
						if (wordList.contains(new String(array))) {
							begin.add(new String(array));
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
