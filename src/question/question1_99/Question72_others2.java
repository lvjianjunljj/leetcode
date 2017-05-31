package question.question1_99;

//修改算法以后可以降低空间复杂度为Omin(m, n)需要维护prev和cur两个数
//因为在二维数组中要和点(i - 1, j - 1)进行比较，所以只能对这两个数同时进行维护才能得到其左上角的数
//同时注意向下走的时候有个递加的过程
public class Question72_others2 {
	public int minDistance(String word1, String word2) {
		int m = word1.length(), n = word2.length();
		if (m > n)
			return minDistance(word2, word1);
		int[] s = new int[m + 1];
		for (int i = 0; i <= m; i++)
			s[i] = i;
		int cur = 0, prev = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				prev = s[j];
				if (word1.charAt(j - 1) == word2.charAt(i - 1))
					s[j] = cur;
				else {
					s[j] = Math.min(cur, Math.min(s[j], s[j - 1])) + 1;
				}
				cur = prev;
			}
			cur = ++s[0];
		}
		return s[m];
	}
}
