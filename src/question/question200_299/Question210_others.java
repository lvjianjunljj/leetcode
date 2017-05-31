package question.question200_299;

import java.util.ArrayList;
import java.util.List;

//拓扑排序的另一方法方法——用两个参数j和k的比较来代替队列，减少了耗时
public class Question210_others {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] indegree = new int[numCourses];
		ArrayList<Integer>[] matrix = new ArrayList[numCourses];
		for (int i = 0; i < numCourses; i++)
			matrix[i] = new ArrayList<Integer>();
		for (int[] i : prerequisites) {
			matrix[i[1]].add(i[0]);
			indegree[i[0]]++;
		}
		int[] res = new int[numCourses];
		int k = 0, j = 0;
		for (int i = 0; i < numCourses; i++)
			if (indegree[i] == 0)
				res[k++] = i;
		while (k < numCourses) {
			if (k == j)
				return new int[0];
			List<Integer> list = matrix[res[j++]];
			for (int i : list)
				if (--indegree[i] == 0)
					res[k++] = i;
		}
		return res;
	}
}
