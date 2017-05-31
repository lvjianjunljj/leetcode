package question.question300_399;
//这种交换的想法用数组来实现才是耗时最低的——同时这种交换的思路用下面的while循环要好过用for循环（更清晰）
public class Question344_others2 {
	public String reverseString(String s) {
		char[] list = s.toCharArray();
		int i = 0, j = s.length() - 1;
		while (i < j) {
			char tmp = list[i];
			list[i] = list[j];
			list[j] = tmp;
			i++;
			j--;
		}
		return new String(list);
	}
}
