package question.question1_99;

/*
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code, 
 * print the sequence of gray code. A gray code sequence must begin with 0.
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * Note:
 * For a given n, a gray code sequence is not uniquely defined.
 * For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 * For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 */
import java.util.ArrayList;
import java.util.List;

//其实想明白了很简单——这种规则导致grayCode(n- 1)是grayCode(n)的前半部分，
//而后半部分是grayCode(n- 1)的倒序然后在其二进制数前加1
//这里是用递归做的，完全也可以用迭代去做
public class Question89_own1 {
	public List<Integer> grayCode(int n) {
		List<Integer> res = new ArrayList<Integer>();
		if (n == 0) {
			res.add(0);
			return res;
		}
		List<Integer> prev = grayCode(n - 1);
		int l = prev.size() - 1;
		for (int i = l; i >= 0; i--)
			prev.add(prev.get(i) + (1 << (n - 1)));
		return prev;
	}
}
