package question.question400_499;

/*
 * Given four lists A, B, C, D of integer values, 
 * compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
 * To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. 
 * All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be 
 * at most 231 - 1.
 * Example:
 * Input:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 * Output:
 * 2
 * Explanation:
 * The two tuples are:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 */
import java.util.HashMap;
import java.util.Map;

//就这也叫方法，和暴力破解有什么区别，HashMap果然是快点——再等等说不定会有BFS的方法
public class Question454_others {
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		Map<Integer, Integer> map = new HashMap<>();
		int n = A.length, res = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int target = 0 - A[i] - B[j];
				if (!map.containsKey(target)) {
					map.put(target, 0);
				}
				map.put(target, map.get(target) + 1);
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map.containsKey(C[i] + D[j])) {
					res += map.get(C[i] + D[j]);
				}
			}
		}
		return res;
	}
}
