package question.question400_499;

//优化一下own1的算法，找到升序中所有比下一个降序大的数删除掉——但耗时还是很高，赶不上大部队
//类似123451会直接删除2345（k但与等于4的时候，如果k是3就删345）
public class Question402_own2 {
	public String removeKdigits(String num, int k) {
		if (num.length() == k)
			return "0";
		while (k > 0) {
			boolean mark = true;
			for (int i = 1; i < num.length(); i++)
				if (num.charAt(i) < num.charAt(i - 1)) {
					mark = false;
					int j = 1, end = Math.min(i, k);
					while (j <= end && num.charAt(i - j) > num.charAt(i))
						j++;
					num = num.substring(0, i - j + 1) + num.substring(i);
					k = k - j + 1;
					break;
				}
			if (mark) {
				num = num.substring(0, num.length() - k);
				k = 0;
			}
		}
		int i = 0;
		while (i < num.length() - 1 && num.charAt(i) == '0')
			i++;
		return num.substring(i);
	}
}
