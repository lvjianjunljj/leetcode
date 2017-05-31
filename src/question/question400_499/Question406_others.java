package question.question400_499;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

//既然有多次插入那就可以用LinkedList，不过要稍微修改一下排序规则，而compare方法本身也能简化一下
public class Question406_others {
	public int[][] reconstructQueue(int[][] people) {
		Comparator<int[]> c = new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
			}
		};
		Arrays.sort(people, c);
		LinkedList<int[]> l = new LinkedList<int[]>();
		for (int[] i : people)
			l.add(i[1], i);
		int[][] res = new int[people.length][2];
		for (int i = 0; i < people.length; i++) {
			res[i][0] = l.get(i)[0];
			res[i][1] = l.get(i)[1];
		}
		return res;
	}
}
