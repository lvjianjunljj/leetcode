package question.question200_299;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
//对BFS进行了优化
public class Question207_others2 {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		ArrayList[] matrix = new ArrayList[numCourses];
		for (int i = 0; i < numCourses; i++)
			matrix[i] = new ArrayList<Integer>();
		int[] indegree = new int[numCourses];
		int count = 0;
		for (int i = 0; i < prerequisites.length; i++) {
			if (!matrix[prerequisites[i][0]].contains(prerequisites[i][1]))
				indegree[prerequisites[i][1]]++;
			matrix[prerequisites[i][0]].add(prerequisites[i][1]);
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < numCourses; i++)
			if (indegree[i] == 0)
				queue.add(i);
		while (!queue.isEmpty()) {
			int course = queue.poll();
			count++;
			for (Object i : matrix[course])
				if (--indegree[(int) (Integer) i] == 0)
					queue.add((Integer) i);
		}
		return count == numCourses;
	}
}
