package question.question1_99;

import java.util.ArrayList;
import java.util.List;

//迭代说什么也要比递归快一点，因为不用每次迭代都重新算k的值了
public class Question89_own2 {
	public List<Integer> grayCode(int n) {
		List<Integer> res = new ArrayList<Integer>();
		res.add(0);
		int k = 1;
		for (int i = 0; i < n; i++) {
			int l = res.size();
			for (int j = l - 1; j >= 0; j--)
				res.add(res.get(j) + k);
			k *= 2;
		}
		return res;
	}
}
