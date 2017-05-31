package question.question100_199;

//本来想用贪心做，但是是不行的——对于"aaabaa"先取前面最长的回文的方法就是不行的
//老子的一维动态规划超时了，一定是每次调用维护的这个判断方法太耗时了，没办法了
public class Question132_own2 {
	public int minCut(String s) {
		char[] list = s.toCharArray();
		int n = list.length;
		int[] cuts = new int[n + 1];
		cuts[0] = -1;
		for (int i = 1; i <= n; i++)
			cuts[i] = n - 1;
		for (int i = 1; i < n + 1; i++) {
			for (int j = 0; j < i; j++) {
				if (isPalindrome(list, j, i))
					cuts[i] = Math.min(cuts[i], cuts[j] + 1);
				if (cuts[i] == 0)
					break;
			}
		}
		return cuts[n];
	}

	private boolean isPalindrome(char[] list, int i, int j) {
		for (int k = i; k < i + (j - i) / 2; k++)
			if (list[k] != list[j + i - k - 1])
				return false;
		return true;
	}
}
