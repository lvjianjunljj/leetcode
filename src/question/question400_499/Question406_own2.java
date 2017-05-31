package question.question400_499;

import java.util.Arrays;
import java.util.Comparator;

//针对own1进行精炼，没必要封装一个内部类，直接对已给的数组通过第一列对其进行排序然后遍历这个数组将其插入到res中就行了
public class Question406_own2 {
	public int[][] reconstructQueue(int[][] people) {
		int n = people.length;
		Comparator c = new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				if (((int[]) o1)[0] > ((int[]) o2)[0])
					return 1;
				else if (((int[]) o1)[0] < ((int[]) o2)[0])
					return -1;
				else {
					if (((int[]) o1)[1] > ((int[]) o2)[1])
						return 1;
					else if (((int[]) o1)[1] < ((int[]) o2)[1])
						return -1;
					else
						return 0;
				}
			}
		};
		Arrays.sort(people, c);
		int[][] res = new int[n][2];
		for (int i = 0; i < n; i++)
			res[i][0] = -1;
		for (int i = 0; i < n; i++) {
			int order = people[i][1], start = 0;
			while (res[start][0] != -1 && res[start][0] != people[i][0])
				start++;
			while (order > 0) {
				if (res[start][0] == people[i][0] || res[start][0] == -1)
					order--;
				start++;
			}
			while (res[start][0] != -1)
				start++;
			res[start][0] = people[i][0];
			res[start][1] = people[i][1];
		}
		return res;
	}
}
