package question.question100_199;

/*
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */
import help.TreeNode;

//用分治很快就出来了——用递归去实现——最常规正统的方法，没别的了
public class Question108_own {
	public TreeNode sortedArrayToBST(int[] nums) {
		return aux(nums, 0, nums.length - 1);
	}

	private TreeNode aux(int[] nums, int i, int j) {
		if (i > j)
			return null;
		int mid = (i + j) / 2;
		TreeNode res = new TreeNode(nums[mid]);
		res.left = aux(nums, i, mid - 1);
		res.right = aux(nums, mid + 1, j);
		return res;
	}
}
