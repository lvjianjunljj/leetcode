package question.question400_499;

//并不是用数组速度快，而是本身这种思路非常好，相当于遍历num一个个地将字符放到数组中碰到小的就不断向前放
//直到k为零了或者到头了——思路还是巧妙，注意这里c < list[top - 1]是要用top - 1
public class Question402_others {
	public String removeKdigits(String num, int k) {
		int digits = num.length() - k;
		char[] list = new char[num.length()];
		int top = 0;
		for (int i = 0; i < num.length(); i++) {
			char c = num.charAt(i);
			while (top > 0 && c < list[top - 1] && k > 0) {
				k--;
				top--;
			}
			list[top++] = c;
		}
		int start = 0;
		while (start < num.length() && list[start] == '0')
			start++;
		return start >= digits ? "0" : new String(list, start, digits - start);
	}
}
