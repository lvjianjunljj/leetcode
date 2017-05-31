package question.question300_399;

import java.util.HashMap;
import java.util.Iterator;

//完全可以将一个矩形的四个点标记成不同（通过位运算区别，四个点分别用1248表示即可），一个点以同样的标志出现两次可定就重复了
//然后根据其出现的次数来看这点是否是最终的矩形的顶点（出现奇数次是），然后再判断一下面积就行
public class Question391_others2 {

	HashMap<String, Integer> map = new HashMap<String, Integer>();

	public boolean isRectangleCover(int[][] rectangles) {
		int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE, bottom = Integer.MAX_VALUE, top = Integer.MIN_VALUE, area = 0;
		for (int[] rec : rectangles) {
			left = Math.min(left, rec[0]);
			right = Math.max(right, rec[2]);
			bottom = Math.min(bottom, rec[1]);
			top = Math.max(top, rec[3]);
			area += (rec[2] - rec[0]) * (rec[3] - rec[1]);
			if (judge(rec[0] + " " + rec[1], 1))
				return false;
			if (judge(rec[0] + " " + rec[3], 2))
				return false;
			if (judge(rec[2] + " " + rec[1], 4))
				return false;
			if (judge(rec[2] + " " + rec[3], 8))
				return false;
		}
		Iterator<Integer> it = map.values().iterator();
		int count = 0;
		while (it.hasNext()) {
			int i = it.next();
			if (i == 1 || i == 2 || i == 4 || i == 8 || i == 7 || i == 11
					|| i == 13 || i == 14)
				count++;
		}
		return count == 4 && area == (right - left) * (top - bottom);
	}

	private boolean judge(String point, int mark) {
		Integer value = map.get(point);
		if (value == null)
			value = mark;
		else if ((value & mark) != 0)
			return true;
		else
			value |= mark;
		map.put(point, value);
		return false;
	}
}
