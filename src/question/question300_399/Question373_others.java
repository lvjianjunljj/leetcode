package question.question300_399;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
//用自己封装的Tuple类——其中x代表第一个数组的坐标，y代表第二个数组的坐标，val代表对应坐标的和
//写好compareTo方法，就是以val值作为排序的衡量，剩下就是用优先队列做了
//小技巧就是类比成378的二维矩阵，首先把第一行全加进去，然后取出一个就把其正下方的数加进去（一定比取出的数大）
//第一行已经全加进去，所以不用担心取出的数的右边的数没加进去，因为这个数的上边的数迟早会被取出
//因为只要提取前k个，所以这样做，没必要一上来就全加进去。
public class Question373_others {

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

	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		int m = nums1.length, n = nums2.length;
		List<int[]> res = new ArrayList<int[]>();
		if (m == 0 || n == 0)
			return res;
		PriorityQueue<Tuple> queue = new PriorityQueue<Tuple>();
		for (int i = 0; i < n; i++)
			queue.offer(new Tuple(0, i, nums1[0] + nums2[i]));
		for (int i = 0; i < Math.min(m * n, k); i++) {
			Tuple t = queue.poll();
			res.add(new int[] { nums1[t.x], nums2[t.y] });
			if (t.x == m - 1)
				continue;
			queue.offer(new Tuple(t.x + 1, t.y, nums1[t.x + 1] + nums2[t.y]));
		}
		return res;
	}
}
