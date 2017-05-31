package question.question300_399;

/*
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 * Example:
 * matrix = [
 * [ 1,  5,  9],
 * [10, 11, 13],
 * [12, 13, 15]
 * ],
 * k = 8,
 * return 13.
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ n2.
 */
//受到了373_own2方法的启发就能做出这个方法，但是耗时还是很高的，没有用到纵向也是sorted的属性，一定有更好的方法
public class Question378_own {
	public int kthSmallest(int[][] matrix, int k) {
		int n = matrix.length;
		int[] index = new int[n];
		int res = 0;
		while (k > 0) {
			int element = Integer.MAX_VALUE;
			int ind = 0;
			for (int i = 0; i < n; i++) {
				if (index[i] < n && element > matrix[i][index[i]]) {
					element = matrix[i][index[i]];
					ind = i;
				}
			}
			res = element;
			index[ind]++;
			k--;
		}
		return res;
	}
}
