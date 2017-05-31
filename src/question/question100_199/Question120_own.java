package question.question100_199;

import java.util.List;


/*
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * For example, given the following triangle
 [
 [2],
 [3,4],
 [6,5,7],
 [4,1,8,3]
 ]
 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 */
//就是一层层向上走
public class Question120_own {
	public int minimumTotal(List<List<Integer>> triangle) {
		int n = triangle.size();
		for (int i = n - 2; i > -1; i--) {
			for (int j = 0; j < i + 1; j++) {
				triangle.get(i).set(
						j,
						Math.min(triangle.get(i + 1).get(j), triangle
								.get(i + 1).get(j + 1))
								+ triangle.get(i).get(j));
			}
		}
		return triangle.get(0).get(0);
	}
}
