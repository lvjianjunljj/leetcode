package question.question400_499;

/*
 * A sequence of number is called arithmetic if it consists of at least three elements and 
 * if the difference between any two consecutive elements is the same.
 * For example, these are arithmetic sequence:
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * The following sequence is not arithmetic.
 * 1, 1, 2, 5, 7
 * A zero-indexed array A consisting of N numbers is given. 
 * A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.
 * A slice (P, Q) of array A is called arithmetic if the sequence:
 * A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.
 * The function should return the number of arithmetic slices in the array A.
 * Example:
 * A = [1, 2, 3, 4]
 * return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
 */

//其实思路很简单，先找到依次找到最长的arithmetic然后其中一共包含n * (n - 1) / 2个arithmetic，然后以其终点为起点找下一段
public class Question413_own {

	int res = 0;

	public int numberOfArithmeticSlices(int[] A) {
		int start = 0;
		while (start < A.length) {
			start = search(A, start);
		}
		return res;
	}

	private int search(int[] A, int start) {
		if (start > A.length - 3) {
			return A.length;
		}
		int end = start + 1;
		int dif = A[end] - A[start];
		while (end < A.length && A[end] - A[end - 1] == dif) {
			end++;
		}
		end--;
		res += (end - start - 1) * (end - start) / 2;
		return end - 1;
	}
}
