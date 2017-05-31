package question.question300_399;

/*
 * Given N axis-aligned rectangles where N > 0, determine if they all together 
 * form an exact cover of a rectangular region.
 * Each rectangle is represented as a bottom-left point and a top-right point. 
 * For example, a unit square is represented as [1,1,2,2]. (coordinate of bottom-left point is (1, 1) 
 * and top-right point is (2, 2)).
 * Example 1:
 * rectangles = [
 [1,1,3,3],
 [3,1,4,2],
 [3,2,4,4],
 [1,3,2,4],
 [2,3,3,4]
 ]
 Return true. All 5 rectangles together form an exact cover of a rectangular region.
 Example 2:
 rectangles = [
 [1,1,2,3],
 [1,3,2,4],
 [3,1,4,2],
 [3,2,4,4]
 ]
 Return false. Because there is a gap between the two rectangular regions.
 Example 3:
 rectangles = [
 [1,1,3,3],
 [3,1,4,2],
 [1,3,2,4],
 [3,2,4,4]
 ]
 Return false. Because there is a gap in the top center.
 Example 4:
 rectangles = [
 [1,1,3,3],
 [3,1,4,2],
 [1,3,2,4],
 [2,2,4,4]
 ]
 Return false. Because two of the rectangles overlap with each other.
 */
import java.util.Arrays;
import java.util.Comparator;

//只是在暴力破解的思路上稍微优化了一下——这个答案徘徊在LTE的边缘
//（我觉得本身用面积判断的思路还是蛮好的，就是判断相交的两两比较太耗时）
public class Question391_own {
	public boolean isRectangleCover(int[][] rectangles) {
		int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE, bottom = Integer.MAX_VALUE, top = Integer.MIN_VALUE;
		long area = 0;
		Comparator c = new Comparator() {
			public int compare(Object o1, Object o2) {
				if (((int[]) o1)[1] > ((int[]) o2)[1])
					return 1;
				else if (((int[]) o1)[1] < ((int[]) o2)[1])
					return -1;
				else
					return 0;
			}
		};
		Arrays.sort(rectangles, c);
		for (int i = 0; i < rectangles.length; i++) {
			for (int j = i + 1; j < rectangles.length; j++) {
				if (isInter(rectangles[i][0], rectangles[i][1],
						rectangles[i][2], rectangles[i][3], rectangles[j][0],
						rectangles[j][1], rectangles[j][2], rectangles[j][3]))
					return false;
				if (rectangles[i][3] <= rectangles[j][1])
					break;
			}
		}
		for (int i = 0; i < rectangles.length; i++) {
			left = Math.min(left, rectangles[i][0]);
			right = Math.max(right, rectangles[i][2]);
			bottom = Math.min(bottom, rectangles[i][1]);
			top = Math.max(top, rectangles[i][3]);
			area += (rectangles[i][2] - rectangles[i][0])
					* (rectangles[i][3] - rectangles[i][1]);
		}
		return area == (right - left) * (top - bottom);
	}

	private boolean isInter(int a, int b, int c, int d, int e, int f, int g,
			int h) {
		int left = Math.max(a, e);
		int bottom = Math.max(b, f);
		if (left < Math.min(c, g) && bottom < Math.min(d, h))
			return true;
		return false;
	}
}
