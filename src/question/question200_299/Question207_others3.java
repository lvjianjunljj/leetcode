package question.question200_299;

import java.util.ArrayList;
import java.util.List;

//仿照210的others方法写的，用拓扑排序的序列代替了队列queue，减少了耗时
public class Question207_others3 {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		ArrayList<Integer>[] matrix = new ArrayList[numCourses];
		for (int i = 0; i < numCourses; i++)
			matrix[i] = new ArrayList<Integer>();
		int[] indegree = new int[numCourses];
		for (int[] i : prerequisites) {
			matrix[i[1]].add(i[0]);
			indegree[i[0]]++;
		}
		int[] order = new int[numCourses];
		int k = 0, j = 0;
		for (int i = 0; i < numCourses; i++)
			if (indegree[i] == 0)
				order[k++] = i;
		while (k < numCourses) {
			if (k == j)
				return false;
			List<Integer> list = matrix[order[j++]];
			for (int i : list)
				if (--indegree[i] == 0)
					order[k++] = i;
		}
		return true;
	}
}
