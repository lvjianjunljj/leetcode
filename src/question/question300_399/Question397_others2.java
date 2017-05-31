package question.question300_399;

//将others1的方法改进了一下，用移位代替bitCount方法，代码简洁且耗时降低了
public class Question397_others2 {
	public int integerReplacement(int n) {
		int res = 0;
		while (n != 1) {
			if (n % 2 == 0)
				n >>>= 1;
			else if (n == 3 || (n >>> 1 & 1) == 0)
				n--;
			else
				n++;
			res++;
		}
		return res;
	}
}
