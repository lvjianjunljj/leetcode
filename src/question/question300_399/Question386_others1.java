package question.question300_399;

/*
 * Given an integer n, return 1 - n in lexicographical order.
 * For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
 * Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.
 */
import java.util.ArrayList;
import java.util.List;

//这种根据前一个数确定下一个数的以实现文本排序——最后的while循环是精华
public class Question386_others1 {
	public List<Integer> lexicalOrder(int n) {
		List<Integer> res = new ArrayList<Integer>();
		int k = 1;
		for (int i = 0; i < n; i++) {
			res.add(k);
			if (k * 10 <= n)
				k *= 10;
			else if (k % 10 < 9 && k + 1 <= n)
				k++;
			else {
				while ((k / 10) % 10 == 9) {
					k /= 10;
				}
				k = k / 10 + 1;
			}
		}
		return res;
	}
}
