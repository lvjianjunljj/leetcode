package question.question400_499;

import java.util.HashMap;
import java.util.HashSet;

//用HashMap做，向后加而不能向前找，向前找会超时，之前有道题就是向前找耗时短，这道题不是
//和我的想法其实是一样的，用map稍稍降低了耗时
public class Question403_others1 {
	public boolean canCross(int[] stones) {
		HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
		for (int i : stones)
			map.put(i, new HashSet<Integer>());
		for (int i : stones) {
			HashSet<Integer> set = map.get(i);
			if (i == 0)
				set.add(0);
			else if (i == 1) {
				set.add(1);
				if (map.containsKey(2))
					map.get(2).add(1);
				if (map.containsKey(3))
					map.get(3).add(2);
			} else {
				for (int j : set) {
					if (map.containsKey(i + j))
						map.get(i + j).add(j);
					if (map.containsKey(i + j + 1))
						map.get(i + j + 1).add(j + 1);
					if (j != 1 && map.containsKey(i + j - 1))
						map.get(i + j - 1).add(j - 1);
				}
			}
		}
		return !map.get(stones[stones.length - 1]).isEmpty();
	}
}
