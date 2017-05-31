package question.question1_99;
//用char[]数组耗时要低一点，但是想法本身是一样的。
public class Question60_others2 {
	int[] nums;
	boolean[] mark;

	public int find(int n, int k) {
		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			if (mark[i] == false) {
				cnt++;
			}
			if (cnt == k)
				return i;
		}
		return 0;
	}

	public String getPermutation(int n, int k) {
		char[] array = new char[n];
		int t = 0;
		int p = 0;
		nums = new int[n + 1];
		mark = new boolean[n + 1];
		nums[0] = 1;
		for (int i = 1; i <= n; i++) {
			nums[i] = i * nums[i - 1];
		}
		// 逐位确定，首先确定首位，然后第二位
		for (int i = 0; i < n; i++) {
			t = (k - 1) / nums[n - i - 1];// 确定当前第i位的数值，在n中位置
			p = find(n, t + 1);// 寻找在n中的第t+1位，确定第i为的值
			array[i] = (char) ('0' + p);
			mark[p] = true;// 已经使用过了，所以标记
			k = k - t * nums[n - i - 1];// 在剩下的k中搜索
		}
		String s = String.copyValueOf(array);
		return s;
	}
}
