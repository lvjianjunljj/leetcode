package question.question400_499;

//答案的写法果然精简——最后这两个方法其实直接用加减号写也行，但这么写感觉就是装逼
public class Question400_others {
	public int findNthDigit(int n) {
		int len = 1, start = 1;
		long count = 9;
		while (n > len * count) {
			n -= len * count;
			count *= 10;
			start *= 10;
			len++;
		}
		String last = Integer.toString(start + (n - 1) / len);
		return Character.getNumericValue(last.charAt((n - 1) % len));
	}
}
