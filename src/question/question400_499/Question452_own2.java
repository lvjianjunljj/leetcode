package question.question400_499;

import java.util.Arrays;
import java.util.Comparator;
//其实没必要封装一个类，直接在二维数组上操作就行了，这样还降低了空间复杂度
public class Question452_own2 {
	public int findMinArrowShots(int[][] points) {
		if (points.length == 0) {
			return 0;
		}
		Comparator<int[]> c = new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] > o2[0]) {
					return 1;
				} else if (o1[0] < o2[0]) {
					return -1;
				} else {
					return 0;
				}
			}
		};
		int res = 1;
		int[] cross = new int[] { points[0][0], points[0][1] };
		Arrays.sort(points, c);
		for (int[] b : points) {
			if (b[0] <= cross[1]) {
				cross[0] = b[0];
				cross[1] = Math.min(b[1], cross[1]);
			} else {
				res++;
				cross[0] = b[0];
				cross[1] = b[1];
			}
		}
		return res;
	}
}
