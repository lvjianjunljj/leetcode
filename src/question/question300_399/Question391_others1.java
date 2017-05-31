package question.question300_399;

import java.util.HashSet;

//这个方法简直是简单而粗暴还非常容易懂——简直是美妙
//最后返回时的判断一定要掌握好，因为有各种情况，所以最后set一定仅包含最终矩形的四个顶点且面积相等
public class Question391_others1 {
	public boolean isRectangleCover(int[][] rectangles) {
		HashSet<String> set = new HashSet<String>();
		int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE, bottom = Integer.MAX_VALUE, top = Integer.MIN_VALUE, area = 0;
		for (int[] rec : rectangles) {
			left = Math.min(left, rec[0]);
			right = Math.max(right, rec[2]);
			bottom = Math.min(bottom, rec[1]);
			top = Math.max(top, rec[3]);
			area += (rec[2] - rec[0]) * (rec[3] - rec[1]);
			String s1 = rec[0] + " " + rec[1];
			String s2 = rec[0] + " " + rec[3];
			String s3 = rec[2] + " " + rec[1];
			String s4 = rec[2] + " " + rec[3];
			if (set.contains(s1))
				set.remove(s1);
			else
				set.add(s1);
			if (set.contains(s2))
				set.remove(s2);
			else
				set.add(s2);
			if (set.contains(s3))
				set.remove(s3);
			else
				set.add(s3);
			if (set.contains(s4))
				set.remove(s4);
			else
				set.add(s4);
		}
		return set.contains(left + " " + bottom)
				&& set.contains(left + " " + top)
				&& set.contains(right + " " + bottom)
				&& set.contains(right + " " + top) && set.size() == 4
				&& area == (right - left) * (top - bottom);
	}
}
