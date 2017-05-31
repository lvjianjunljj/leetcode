package question.question300_399;

import java.util.PriorityQueue;
//根据Question373_others的方法，用自己封装的Tuple类——思路完全是一样的
public class Question378_others1 {

	class Tuple implements Comparable<Tuple> {
		int x, y, val;

		public Tuple(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}

		public int compareTo(Tuple that) {
			return this.val - that.val;
		}
	}

	public int kthSmallest(int[][] matrix, int k) {
		PriorityQueue<Tuple> queue = new PriorityQueue<Tuple>();
		for (int i = 0; i < matrix.length; i++)
			queue.offer(new Tuple(i, 0, matrix[i][0]));
		int res = 0;
		for (int i = 0; i < k; i++) {
			Tuple t = queue.poll();
			res = t.val;
			if (t.y == matrix[0].length - 1)
				continue;
			queue.offer(new Tuple(t.x, t.y + 1, matrix[t.x][t.y + 1]));
		}
		return res;
	}
}
