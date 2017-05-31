package question.question400_499;

/*
 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
 * Note:
 * n is positive and will fit within the range of a 32-bit signed integer (n < 231).
 * Example 1:
 * Input:
 * 3
 * Output:
 * 3
 * Example 2:
 * Input:
 * 11
 * Output:
 * 0
 * Explanation:
 * The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
 */

//想法还是不错的，就是写起来有点麻烦了，就是1~9是一位，10~99是两位，100~999是三位，分别计算以位数计数到了多了
public class Question400_own1 {
	public int findNthDigit(int n) {
		if (n < 10)
			return n;
		long th = 9, count = 9, start = 0, i = 1, cur = 0;
		while (th < n) {
			start = start * 10 + 9;
			cur = (count *= 10) * ++i;
			th += cur;
		}
		long len = n - (th - cur);
		if (len == 0)
			return 9;
		long num = len / i;
		if (len % i == 0)
			return (start + num + "").charAt((int) (i - 1)) - '0';
		return (start + num + 1 + "").charAt((int) ((len % i) - 1)) - '0';
	}
}
