package question.question100_199;

import java.util.HashSet;
import java.util.Set;
//与others2同样的思路用HashSet远比用Queue耗时短得多，像这种大数据量而且有重复的还是用HashSet比较快
public class Question127_others4 {
	public int ladderLength(String beginWord, String endWord,
			Set<String> wordList) {
		HashSet<String> begin = new HashSet<String>();
		HashSet<String> end = new HashSet<String>();
		begin.add(beginWord);
		end.add(endWord);
		int dis = 1;
		while (begin.size() != 0 && end.size() != 0) {
			if (begin.size() > end.size()) {
				HashSet<String> temp = begin;
				begin = end;
				end = temp;
			}
			HashSet<String> addWord = new HashSet<String>();
			for (String word : begin) {
				for (int j = 0; j < word.length(); j++) {
					char[] array = word.toCharArray();
					for (int k = 'a'; k <= 'z'; k++) {
						array[j] = (char) k;
						if (end.contains(new String(array)))
							return dis + 1;
						if (wordList.contains(new String(array))) {
							addWord.add(new String(array));
							wordList.remove(new String(array));
						}
					}
				}
			}
			begin = addWord;
			dis++;
		}
		return 0;
	}
}
