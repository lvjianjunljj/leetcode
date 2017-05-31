package question.question100_199;
/*
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 */
//就是根据斜率来做的，最多是加了两个情况的判断——两点重合；两点在同一条y轴上
public class Question149_own {
	public int maxPoints(Point[] points) {
		int n = points.length;
		if (n <= 2)
			return n;
		int res = 2;
		for (int i = 0; i < n; i++) {
			int init = 1;
			for (int j = i + 1; j < n; j++) {
				int cur = init + 1;
				if (points[i].x == points[j].x && points[i].y == points[j].y) {
					if (j < n - 1) {
						init++;
						continue;
					}
				}
				if (points[i].x == points[j].x) {
					for (int m = j + 1; m < n; m++)
						if (points[m].x == points[j].x)
							cur++;
					res = Math.max(res, cur);
				} else {
					double k = (double) (points[j].y - points[i].y)
							/ (double) (points[j].x - points[i].x);
					for (int m = j + 1; m < n; m++) {
						if ((points[m].x == points[i].x && points[m].y == points[i].y))
							cur++;
						else if (points[m].x != points[i].x
								&& (double) (points[m].y - points[i].y)
										/ (double) (points[m].x - points[i].x) == k)
							cur++;
					}
					res = Math.max(res, cur);
				}
			}
		}
		return res;
	}
}

class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}
}
