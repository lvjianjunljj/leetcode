package question.question300_399;

/*
 * You are given an integer array nums and you have to return a new counts array. 
 * The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
 * Example:
 * Given nums = [5, 2, 6, 1]
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 * Return the array [2, 1, 1, 0].
 */
import java.util.Arrays;
import java.util.List;

//sum表示其左子树节点的个数，cup表示该节点的重复数目，val表示这个点锁对应的值
//insert方法中传入的preSum值表示在向下搜索这棵树时之前找到的比起小的点的个数
//用二叉树不只是用于搜索，在创建树的时候也能解决一些问题
public class Question315_others1 {
	class Node {
		Node left, right;
		int sum, cup, val;

		public Node(int val, int sum) {
			this.val = val;
			this.sum = sum;
			cup = 1;
		}
	}

	public List<Integer> countSmaller(int[] nums) {
		Integer[] res = new Integer[nums.length];
		Node root = null;
		for (int i = nums.length - 1; i >= 0; i--)
			root = insert(root, res, i, nums[i], 0);
		return Arrays.asList(res);
	}

	private Node insert(Node node, Integer[] res, int index, int val, int preSum) {
		if (node == null) {
			node = new Node(val, 0);
			res[index] = preSum;
		} else if (val == node.val) {
			node.cup++;
			res[index] = node.sum + preSum;
		} else if (val < node.val) {
			node.sum++;
			node.left = insert(node.left, res, index, val, preSum);
		} else
			node.right = insert(node.right, res, index, val, preSum + node.sum
					+ node.cup);
		return node;
	}
}
