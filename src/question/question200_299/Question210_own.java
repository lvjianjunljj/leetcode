package question.question200_299;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
//仿照question207做的，耗时还算是比较短
public class Question210_own {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] indegree = new int[numCourses];
		ArrayList<Integer>[] matrix = new ArrayList[numCourses];
		for (int i = 0; i < numCourses; i++)
			matrix[i] = new ArrayList<Integer>();
		for (int i = 0; i < prerequisites.length; i++) {
			//这一步在这一道题没有用，给的输入确实没有重复的，少了这一步筛选耗时会低很多，和others的好事就差不多了
			if (matrix[prerequisites[i][1]].indexOf(prerequisites[i][0]) < 0) {
				matrix[prerequisites[i][1]].add(prerequisites[i][0]);
				indegree[prerequisites[i][0]]++;
			}
		}
		int[] res = new int[numCourses];
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < numCourses; i++)
			if (indegree[i] == 0)
				queue.add(i);
		int count = 0;
		while (!queue.isEmpty()) {
			int course = queue.poll();
			res[count++] = course;
			if (count == numCourses)
				return res;
			ArrayList<Integer> array = matrix[course];
			for (int k : array)
				if (--indegree[k] == 0)
					queue.add(k);
		}
		if (count < numCourses)
			return new int[0];
		return res;
	}
}
