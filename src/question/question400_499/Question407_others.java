package question.question400_499;

/*
 * Given an m x n matrix of positive integers representing the height of each unit cell in a 2D elevation map, 
 * compute the volume of water it is able to trap after raining.
 * Note:
 * Both m and n are less than 110. The height of each unit cell is greater than 0 and is less than 20,000.
 * Example:
 * Given the following 3x6 height map:
 * [
 * [1,4,3,1,3,2],
 * [3,2,1,3,2,4],
 * [2,3,3,2,3,1]
 * ]
 * Return 4.
 */
import java.util.PriorityQueue;

//用DFS做确实还是不行，最麻烦的逐点遍历DFS肯定超时了，只能根据答案写一个用优先队列做的方法了
//还要自己封装一个class——其实也可以叫DFS，从四边向中间搜索
public class Question407_others {
	class Cell implements Comparable<Cell> {
		int x;
		int y;
		int h;

		public Cell(int x, int y, int h) {
			this.x = x;
			this.y = y;
			this.h = h;
		}

		@Override
		public int compareTo(Cell o) {
			if (h > o.h) {
				return 1;
			} else if (h < o.h) {
				return -1;
			} else {
				return 0;
			}
		}

	}

	public int trapRainWater(int[][] heightMap) {
		int m = heightMap.length;
		if (m == 0) {
			return 0;
		}
		int n = heightMap[0].length;
		boolean[][] visit = new boolean[m][n];
		PriorityQueue<Cell> queue = new PriorityQueue<Cell>();
		for (int i = 0; i < m; i++) {
			visit[i][0] = true;
			visit[i][n - 1] = true;
			queue.offer(new Cell(i, 0, heightMap[i][0]));
			queue.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
		}
		for (int i = 0; i < n; i++) {
			visit[0][i] = true;
			visit[m - 1][i] = true;
			queue.offer(new Cell(0, i, heightMap[0][i]));
			queue.offer(new Cell(m - 1, i, heightMap[m - 1][i]));
		}
		int sum = 0;
		int[] hor = new int[] { -1, 1, 0, 0 };
		int[] ver = new int[] { 0, 0, -1, 1 };
		while (!queue.isEmpty()) {
			Cell c = queue.poll();
			for (int i = 0; i < 4; i++) {
				int x = c.x + hor[i];
				int y = c.y + ver[i];
				if (x >= 0 && y >= 0 && x < m && y < n && !visit[x][y]) {
					visit[x][y] = true;
					sum += Math.max(0, c.h - heightMap[x][y]);
					queue.offer(new Cell(x, y, Math.max(c.h, heightMap[x][y])));
				}
			}
		}
		return sum;
	}
}
