package question.question100_199;

/*
 * Given an index k, return the kth row of the Pascal's triangle.
 * For example, given k = 3,
 * Return [1,3,3,1].
 */
import java.util.ArrayList;
import java.util.List;
//知道了杨辉三角的生成原理用递归很快就能出来了。
public class Question119_own {
	public List<Integer> getRow(int rowIndex) {
		return aux(rowIndex);
	}

	protected static List<Integer> aux(int n) {
		List<Integer> result = new ArrayList<Integer>();
		result.add(1);
		if (n == 0) {
			return result;
		}
		List<Integer> bef = aux(n - 1);
		for (int i = 0; i < bef.size() - 1; i++) {
			result.add(bef.get(i) + bef.get(i + 1));
		}
		result.add(1);
		return result;
	}
}
