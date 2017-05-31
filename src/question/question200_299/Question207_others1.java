package question.question200_299;

import java.util.LinkedList;
import java.util.Queue;
//其实就是图算法的广度或者深度优先搜索判断有无环的过程，他人给的这种思路还是非常巧妙地，虽然空间复杂度较高，耗时也较长
public class Question207_others1 {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[][] matrix = new int[numCourses][numCourses];
		int[] indegree = new int[numCourses];
		int count = 0;
		for (int i = 0; i < prerequisites.length; i++) {
			if (matrix[prerequisites[i][0]][prerequisites[i][1]] == 0)
				indegree[prerequisites[i][1]]++;
			matrix[prerequisites[i][0]][prerequisites[i][1]] = 1;
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < numCourses; i++)
			if (indegree[i] == 0)
				queue.add(i);
		while (!queue.isEmpty()) {
			int course = queue.poll();
			count++;
			for (int i = 0; i < numCourses; i++)
				if (matrix[course][i] == 1)
					if (--indegree[i] == 0)
						queue.add(i);
		}
		return count == numCourses;
	}
}
