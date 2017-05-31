package question.question100_199;
//直接进行位运算也是可以的，不用考虑正负，这里就能看出除以2和右移1的区别。
//注：“>>”是有符号的右移，和除以没什么区别，“>>>”是无符号的右移，会将最高位视为0或1（正数为0，负数为1）
public class Question191_others1 {
	public int hammingWeight(int n) {
		int sum = 0;
		while (n != 0) {
			sum += n & 1;
			n = n >>> 1;
		}
		return sum;
	}
}
