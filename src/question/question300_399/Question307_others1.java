package question.question300_399;

/*
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * The update(i, val) function modifies nums by updating the element at index i to val.
 * Example:
 * Given nums = [1, 3, 5]
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 * Note:
 * The array is only modifiable by the update function.
 * You may assume the number of calls to update and sumRange function is distributed evenly.
 */

//SegmentTree分割树是解决这类题的比较常规的办法，
//分割树的节点就是封装了数组的其实和结尾两个下标，起始到结尾所有数的和
//以及子数组的左半部分对应的节点以及右半部分对应的节点（若子数组中只有一个数这个两个节点为null）
public class Question307_others1 {
	public class NumArray {
		class SegmentTreeNode {
			int start, end;
			SegmentTreeNode left, right;
			int sum;

			public SegmentTreeNode(int start, int end) {
				this.start = start;
				this.end = end;
				this.left = null;
				this.right = null;
				this.sum = 0;
			}
		}

		SegmentTreeNode root = null;

		public NumArray(int[] nums) {
			root = SetSegmentTree(nums, 0, nums.length - 1);
		}

		private SegmentTreeNode SetSegmentTree(int[] nums, int start, int end) {
			if (start > end)
				return null;
			SegmentTreeNode node = new SegmentTreeNode(start, end);
			if (start == end)
				node.sum = nums[start];
			else {
				int mid = start + (end - start) / 2;
				node.left = SetSegmentTree(nums, start, mid);
				node.right = SetSegmentTree(nums, mid + 1, end);
				node.sum = node.left.sum + node.right.sum;
			}
			return node;
		}

		void update(int i, int val) {
			updateSegmentTree(root, i, val);
		}

		private void updateSegmentTree(SegmentTreeNode node, int index, int val) {
			// 排除输入数组为空的情况
			if (node.start == node.end)
				node.sum = val;
			else {
				int mid = node.start + (node.end - node.start) / 2;
				if (index > mid)
					updateSegmentTree(node.right, index, val);
				else
					updateSegmentTree(node.left, index, val);
				node.sum = node.left.sum + node.right.sum;
			}
		}

		public int sumRange(int i, int j) {
			return getSumSegmentTree(root, i, j);
		}

		private int getSumSegmentTree(SegmentTreeNode node, int start, int end) {
			if (node.start == start && node.end == end)
				return node.sum;
			else {
				int mid = node.start + (node.end - node.start) / 2;
				if (end <= mid)
					return getSumSegmentTree(node.left, start, end);
				else if (start > mid)
					return getSumSegmentTree(node.right, start, end);
				else
					return getSumSegmentTree(node.left, start, mid)
							+ getSumSegmentTree(node.right, mid + 1, end);
			}
		}
	}
}
