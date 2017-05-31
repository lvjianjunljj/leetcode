package question.question100_199;

/*
 * Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 5,
 * [
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
 ]
 */
//
import java.util.ArrayList;
import java.util.List;
//和118一样的，知道了杨辉三角的构成很快就能出来了
public class Question118_own {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (numRows == 0) {
			return result;
		}
		List<Integer> first = new ArrayList<Integer>();
		first.add(1);
		result.add(first);
		for (int i = 1; i < numRows; i++) {
			List<Integer> bef = result.get(i - 1);
			List<Integer> cur = new ArrayList<Integer>();
			cur.add(1);
			for (int j = 1; j < bef.size(); j++) {
				cur.add(bef.get(j - 1) + bef.get(j));
			}
			cur.add(1);
			result.add(cur);
		}
		return result;
	}
}
