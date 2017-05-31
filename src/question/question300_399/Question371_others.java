package question.question300_399;
//将两个数视为本身的数组和仅为数组，一直递归到仅为数组为零了就结束了
public class Question371_others {
	public int getSum(int a, int b) {
		return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
	}
}
