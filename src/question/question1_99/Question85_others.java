package question.question1_99;

//用动态规划做，只维护了三个一维数组就可以了。
//其实思路很简单，就是对一个点从左到右找到left，从右打左找到right，从上到下找到height。
public class Question85_others {
	public int maximalRectangle(char[][] matrix) {
		int m = matrix.length;
		if (m == 0)
			return 0;
		int n = matrix[0].length;
		int[] right = new int[n];
		for (int i = 0; i < n; i++)
			right[i] = n;
		int[] left = new int[n];
		int[] height = new int[n];
		int max = 0, curLeft = 0, curRight = n;
		for (int i = 0; i < m; i++) {
			curLeft = 0;
			curRight = n;
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1') {
					height[j]++;
					left[j] = Math.max(curLeft, left[j]);
				} else {
					height[j] = 0;
					left[j] = 0;
					curLeft = j + 1;
				}
			}
			//right属性是从右向左封装的，必须从写一个循环，而height和left属性可以合成一个写
			for (int j = n - 1; j >= 0; j--) {
				if (matrix[i][j] == '1') {
					right[j] = Math.min(curRight, right[j]);
				} else {
					right[j] = n;
					curRight = j;
				}
			}
			for (int j = 0; j < n; j++)
				max = Math.max(max, (right[j] - left[j]) * height[j]);
		}
		return max;
	}
}
