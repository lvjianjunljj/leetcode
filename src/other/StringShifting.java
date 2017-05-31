package other;

import java.util.Scanner;

/*
 * 我们规定对一个字符串的shift操作如下: 
 * shift(“ABCD”,0)=”ABCD” 
 * shift(“ABCD”,1)=”BCDA” 
 * shift(“ABCD”,2)=”CDAB”
 * 换言之, 我们把最左侧的N个字符剪切下来, 按序附加到右侧.
 * 给定一个长度为n的字符串, 规定最多可以进行n次循环shift操作。 
 * 如果shift(string, x) = string(0 <= x < n). 我们称其为一次匹配(match), 求shift过程中匹配的次数…
 * 输入描述 
 * 输入仅包括一个输入的字符串, 字符串中仅有大小写字母
 * 输出描述 
 * 输出仅包括一行, 即匹配的次数
 * 样例输入:
 * byebyebye
 * 样例输出:
 * 3
 * hint: 
 * 30%的样例中输入字符串的长度<100, 
 * 100%的样例中输入字符串的长度<10^6
 */

public class StringShifting {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String str = in.next();
			int len = str.length();
			int[] dp = new int[len + 1];
			int i = 0;
			int j = -1;
			dp[0] = -1;
			while (i < len) {
				if (j == -1 || str.charAt(i) == str.charAt(j)) {
					i++;
					j++;
					dp[i] = j;
				} else
					// 这一步是是精华，可以减少耗时
					j = dp[j];
			}

			if (len % (len - dp[len]) == 0)
				System.out.println(len / (len - dp[len]));
			else
				System.out.println(1);

		}
	}
}
