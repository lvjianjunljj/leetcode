package question.question100_199;
//这个方法其实和右移1位思路上也是差不多的，这里是找是1的最后一位，然后将其置0.
public class Question191_others2 {
	public int hammingWeight(int n) {
		int count = 0;
		while (n != 0) {
			n &= (n - 1);
			count++;
		}
		return count;
	}
}
