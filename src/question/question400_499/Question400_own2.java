package question.question400_499;

//根据答案给的提示稍微做了修改，精简了一下
public class Question400_own2 {
	public int findNthDigit(int n) {
		if (n < 10)
			return n;
		long th = 9, count = 9, start = 0, i = 1, cur = 0;
		while (th < n) {
			start = start * 10 + 9;
			cur = (count *= 10) * ++i;
			th += cur;
		}
		long len = n - (th - cur) - 1;
		long num = len / i;
		return (start + num + 1 + "").charAt((int) ((len % i))) - '0';
	}
}
