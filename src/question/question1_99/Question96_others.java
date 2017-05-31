package question.question1_99;

/*
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 */

//这波动态规划加数学分析我简直是拜服。。。服。。。
//dp[i]的求法是对应i这个数的TreeNode的父树和左节点（因为i是最大的数所以只能是左节点）分别有0到i - 1个和i - 1到0
//所对应的情况分别有dp[j] * dp[i - 1 - j]种
//也可以理解成对于n来说1到n这n个数每一个数作为父节点左子树有i - 1个数，右子树有n - i个数，对应有dp[j] * dp[i - 1 - j]种
//情况，全部相加——这个理解有助于做95题
//服~~~~~~~~~~~~~~~~~~~~~~~~
public class Question96_others {
	public int numTrees(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 1;
		for (int i = 1; i <= n; i++)
			for (int j = 0; j < i; j++)
				dp[i] += dp[j] * dp[i - 1 - j];
		return dp[n];
	}
}
