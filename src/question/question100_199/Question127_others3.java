package question.question100_199;

import java.util.HashSet;
import java.util.Set;
//与others1同样的思路，但是用HashSet并没有比用Queue耗时短，与others2与others4的情况不一样，我也很懵逼
public class Question127_others3 {
	public int ladderLength(String beginWord, String endWord,
			Set<String> wordList) {
		HashSet<String> set = new HashSet<String>();
		set.add(beginWord);
		wordList.add(endWord);
		int dis = 1;
		while (set.size() != 0) {
			HashSet<String> temp = new HashSet<String>();
			for (String word : set) {
				if (word.equals(endWord))
					return dis;
				for (int j = 0; j < word.length(); j++) {
					char[] array = word.toCharArray();
					for (int k = 'a'; k <= 'z'; k++) {
						array[j] = (char) k;
						if (wordList.contains(new String(array))) {
							temp.add(new String(array));
							wordList.remove(new String(array));
						}
					}
				}
			}
			dis++;
			set = temp;
		}
		return 0;
	}
}
