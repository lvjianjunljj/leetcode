package question.question1_99;

/*
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * For example,\
 * Given n = 3, your program should return all 5 unique BST's shown below.
 */
import help.TreeNode;
import java.util.ArrayList;
import java.util.List;

//用96题的思路理解成对于n来说1到n这n个数每一个数作为父节点左子树有i - 1个数，右子树有n - i个数，
//对应有dp[j] * dp[i - 1 - j]种情况，全部相加
//为了防止对加入TreeNode元素的修改，所以在所有循环的最里层构建整个树——从root开始
//和top1的想法一样——但是耗时不是最低的
public class Question95_own {
	public List<TreeNode> generateTrees(int n) {
		if (n == 0)
			return new ArrayList<TreeNode>();
		return aux(1, n);
	}

	private List<TreeNode> aux(int i, int j) {
		List<TreeNode> res = new ArrayList<TreeNode>();
		res.add(null);
		if (i > j)
			return res;
		else
			res.remove(0);
		if (i == j) {
			res.add(new TreeNode(i));
			return res;
		}
		for (int k = i; k <= j; k++) {
			for (TreeNode left : aux(i, k - 1)) {
				for (TreeNode right : aux(k + 1, j)) {
					TreeNode root = new TreeNode(k);
					root.left = left;
					root.right = right;
					res.add(root);
				}
			}
		}
		return res;
	}
}
