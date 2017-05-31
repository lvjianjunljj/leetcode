package question.question400_499;

import java.util.HashMap;

//这个方法的思路还是可取的，但是key = pos | k << 11的写法不太对——针对这道题的输出暂时能AC（当输入情况足够多时会出现错误）
//就是针对每一个点pos和到该点的步数k用一个较大的数去维护，然后将其存到map中并有对应的boolean值
public class Question403_others2 {
	public boolean canCross(int[] stones) {
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		return aux(map, stones, 0, 0);
	}

	private boolean aux(HashMap<Integer, Boolean> map, int[] stones, int pos,
			int k) {
		int key = pos | k << 11;
		if (map.containsKey(key))
			return map.get(key);
		for (int i = pos + 1; i < stones.length; i++) {
			int dis = stones[i] - stones[pos];
			if (dis < k - 1)
				continue;
			if (dis > k + 1) {
				map.put(key, false);
				return false;
			}
			if (aux(map, stones, i, dis)) {
				map.put(key, true);
				return true;
			}
		}
		map.put(key, pos == stones.length - 1);
		return pos == stones.length - 1;
	}
}
