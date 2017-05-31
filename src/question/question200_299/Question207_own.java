package question.question200_299;

/*
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 * For example:
 * 2, [[1,0]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
 * 2, [[1,0],[0,1]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 */
import java.util.HashMap;
import java.util.HashSet;
//我尽力了，没想到第一个BFS的题我就超时了
public class Question207_own {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
		for (int i = 0; i < prerequisites.length; i++) {
			if (map.containsKey(prerequisites[i][0]))
				map.get(prerequisites[i][0]).add(prerequisites[i][1]);
			else {
				map.put(prerequisites[i][0], new HashSet<Integer>());
				map.get(prerequisites[i][0]).add(prerequisites[i][1]);
			}
		}
		for (int i = 0; i < numCourses; i++)
			if (!aux(map, new HashSet<Integer>(), i, i))
				return false;
		return true;
	}

	private boolean aux(HashMap<Integer, HashSet<Integer>> map,
			HashSet<Integer> hash, int i, int n) {
		if (!map.containsKey(i))
			return true;
		HashSet<Integer> set = map.get(i);
		for (int j : set) {
			if (j == n)
				return false;
			if (hash.contains(j))
				return true;
			else
				hash.add(j);
			if (!aux(map, hash, j, n))
				return false;
		}

		return true;
	}
}
