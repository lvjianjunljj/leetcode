package question.question1_99;

import java.util.PriorityQueue;

//与407的想法一致的一个做法，用在这种一维的题目上确实有点大材小用，但确实也是一种做法
public class Question42_own2 {

	class Cell implements Comparable<Cell> {
		int index;
		int high;

		public Cell(int index, int high) {
			this.index = index;
			this.high = high;
		}

		@Override
		public int compareTo(Cell o) {
			if (high > o.high) {
				return 1;
			} else if (high < o.high) {
				return -1;
			} else {
				return 0;
			}
		}
	}

	public int trap(int[] height) {
		int sum = 0;
		int n = height.length;
		if (n < 3) {
			return sum;
		}
		boolean[] visit = new boolean[n];
		visit[0] = true;
		visit[n - 1] = true;
		PriorityQueue<Cell> queue = new PriorityQueue<Cell>();
		queue.offer(new Cell(0, height[0]));
		queue.offer(new Cell(n - 1, height[n - 1]));
		while (!queue.isEmpty()) {
			Cell cell = queue.poll();
			if (cell.index > 0 && !visit[cell.index - 1]) {
				visit[cell.index - 1] = true;
				sum += Math.max(0, cell.high - height[cell.index - 1]);
				queue.offer(new Cell(cell.index - 1, Math.max(cell.high,
						height[cell.index - 1])));
			}
			if (cell.index + 1 < n && !visit[cell.index + 1]) {
				visit[cell.index + 1] = true;
				sum += Math.max(0, cell.high - height[cell.index + 1]);
				queue.offer(new Cell(cell.index + 1, Math.max(cell.high,
						height[cell.index + 1])));
			}
		}
		return sum;
	}
}
