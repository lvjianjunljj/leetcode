package algorithm;

public class Manacher {
	public static void main(String[] args) {
		System.out.println(getPalindromeLength("aa"));
	}

	public static String getPalindromeLength(String str) {
		// 1.构造新的字符串
		// 为了避免奇数回文和偶数回文的不同处理问题，在原字符串中插入'#'，将所有回文变成奇数回文
		StringBuilder newStr = new StringBuilder();
		newStr.append('#');
		for (int i = 0; i < str.length(); i++) {
			newStr.append(str.charAt(i));
			newStr.append('#');
		}
		int maxLength = 0, index = 0;

		// rad[i]表示以i为中心的回文的最大半径，i至少为1，即该字符本身
		int[] rad = new int[newStr.length()];
		// right表示已知的回文中，最右的边界的坐标
		int right = -1;
		// id表示已知的回文中，拥有最右边界的回文的中点坐标
		int id = -1;
		// 2.计算所有的rad
		// 这个算法是O(n)的，因为right只会随着里层while的迭代而增长，不会减少。
		for (int i = 0; i < newStr.length(); i++) {
			// 2.1.确定一个最小的半径
			int r = 1;
			if (i <= right) {
				r = Math.min(right - i, rad[2 * id - i]);
			}
			// 2.2.尝试更大的半径 
			/*
			 * 当i在right内时rad[2 * id - i]和rad[i]是不重合的，那就不需要进入这个while循环
			 * newStr.charAt(i - r) == newStr.charAt(i + r)这个条件就是用来限制这个情况的
			 */
			while (i - r >= 0 && i + r < newStr.length()
					&& newStr.charAt(i - r) == newStr.charAt(i + r)) {
				r++;
			}
			// 2.3.更新边界和回文中心坐标
			if (i + r - 1 > right) {
				right = i + r - 1;
				id = i;
			}
			rad[i] = r;
			System.out.println(rad[i]);
			if (rad[i] > maxLength) {
				maxLength = rad[i];
				index = i;
			}
		}

		// 3.扫描一遍rad数组，找出最大的半径——这一步可以在之前的循环中完成
		StringBuilder sb = new StringBuilder();

		for (int i = 1 - maxLength; i < maxLength - 1; i++)
			if (newStr.charAt(index + i) != '#')
				sb.append(newStr.charAt(index + i));
		return sb.toString();

	}
}
