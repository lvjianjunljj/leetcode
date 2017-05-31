package question.question400_499;

/*
 * You are given a binary tree in which each node contains an integer value.
 * Find the number of paths that sum to a given value.
 * The path does not need to start or end at the root or a leaf, but it must go downwards 
 * (traveling only from parent nodes to child nodes).
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 * Example:
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

 10
 /  \
 5   -3
 / \    \
 3   2   11
 / \   \
 3  -2   1

 Return 3. The paths that sum to 8 are:
 1.  5 -> 3
 2.  5 -> 2 -> 1
 3. -3 -> 11
 */
import help.TreeNode;

//这种想法的耗时极高，针对每一个点都要重新向下dfs，不是一个好思路，再想想别的
1
public class Question437_own1 {
	public int pathSum(TreeNode root, int sum) {
		return search(root, sum)
				+ (root == null ? 0 : pathSum(root.left, sum)
						+ pathSum(root.right, sum));
	}

	private int search(TreeNode root, int count) {
		if (root == null) {
			return 0;
		}
		return (root.val == count ? 1 : 0)
				+ search(root.left, count - root.val)
				+ search(root.right, count - root.val);
	}
}
