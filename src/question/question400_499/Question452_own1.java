package question.question400_499;

/*
 * There are a number of spherical balloons spread in two-dimensional space. 
 * For each balloon, provided input is the start and end coordinates of the horizontal diameter. 
 * Since it's horizontal, y-coordinates don't matter and hence the x-coordinates of start and end 
 * of the diameter suffice. Start is always smaller than end. There will be at most 104 balloons.
 * An arrow can be shot up exactly vertically from different points along the x-axis. 
 * A balloon with xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend. 
 * There is no limit to the number of arrows that can be shot. 
 * An arrow once shot keeps travelling up infinitely. 
 * The problem is to find the minimum number of arrows that must be shot to burst all balloons.
 * Example:
 * Input:
 * [[10,16], [2,8], [1,6], [7,12]]
 * Output:
 * 2
 * Explanation:
 * One way is to shoot one arrow for example at x = 6 
 * (bursting the balloons [2,8] and [1,6]) and another arrow at x = 11 (bursting the other two balloons).
 */
import java.util.Arrays;

//没什么意思，不需要动态规划，排好序以后用贪心一步步向后走就行了，没有相交的就需要下一个shot，就这样就能出来了
public class Question452_own1 {

	class Balloon implements Comparable<Balloon> {
		int start;
		int end;

		public Balloon(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Balloon o1) {
			if (start > o1.start) {
				return 1;
			} else if (start < o1.start) {
				return -1;
			} else {
				return 0;
			}
		}
	}

	public int findMinArrowShots(int[][] points) {
		if (points.length == 0) {
			return 0;
		}
		Balloon[] balloons = new Balloon[points.length];
		for (int i = 0; i < points.length; i++) {
			balloons[i] = new Balloon(points[i][0], points[i][1]);
		}
		int res = 1;
		int[] cross = new int[] { balloons[0].start, balloons[0].end };
		Arrays.sort(balloons);
		for (Balloon b : balloons) {
			if (b.start <= cross[1]) {
				cross[0] = b.start;
				cross[1] = Math.min(b.end, cross[1]);
			} else {
				res++;
				cross[0] = b.start;
				cross[1] = b.end;
			}
		}
		return res;
	}
}
