package question.question300_399;

//维护一个部分和数组，这个方法能读懂但是根本想不到啊
/*
 * 维护的结构大约是这样的
 * 1 2 3 4 5 6 7 8 9
 * 1 1   1       1
 *   2   2       2
 *     3 3       3
 *       4       4
 *         5 5   5
 *           6   6
 *             7 7
 *               8
 *                 9
 *所以用tree求和的时候向下加到坐标为2的次幂时就结束了，而update时只需要更新向后数个tree中的值就行
 *所以各个操作的时间复杂度都是logn
 */
public class Question307_others2 {
	public class NumArray {

		int[] nums;
		int[] tree;
		int size;

		public NumArray(int[] nums) {
			this.nums = nums;
			size = nums.length;
			this.tree = new int[size];
			for (int i = 0; i < size; i++)
				updateTree(i + 1, nums[i]);
		}

		private void updateTree(int i, int val) {
			while (i <= size) {
				tree[i - 1] += val;
				i += i & (-i);
			}
		}

		void update(int i, int val) {
			updateTree(i + 1, val - nums[i]);
			nums[i] = val;
		}

		private int getSumTree(int i) {
			i++;
			int res = 0;
			while (i > 0) {
				res += tree[i - 1];
				i -= i & (-i);
			}
			return res;
		}

		public int sumRange(int i, int j) {
			return getSumTree(j) - getSumTree(i - 1);
		}
	}
}
