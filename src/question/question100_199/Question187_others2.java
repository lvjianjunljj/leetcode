package question.question100_199;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
//这个方法其实也很好，简单粗暴耗时也低
public class Question187_others2 {
	public List<String> findRepeatedDnaSequences(String s) {
		List<String> res = new ArrayList<String>();
		HashSet<String> set = new HashSet<String>();
		HashSet<String> reset = new HashSet<String>();
		for (int i = 0; i < s.length() - 9; i++)
			if (!set.add(s.substring(i, i + 10)))
				reset.add(s.substring(i, i + 10));
		res.addAll(reset);
		return res;
	}
}
