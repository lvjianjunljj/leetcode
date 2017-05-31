package question.question300_399;

/*
 * For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.
 * Format
 * The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).
 * You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 * Example 1:
 * Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]

 0
 |
 1
 / \
 2   3
 return [1]
 Example 2:
 Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

 0  1  2
 \ | /
 3
 |
 4
 |
 5
 return [3, 4]
 */
import java.util.ArrayList;
import java.util.List;
//我的想法送遍历每个点用bfs求其深度，时间复杂对应该是On2，但是确实超时了，一脸懵逼。得看看答案给的说明方法了
public class Question310_own1 {
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		int[] highs = new int[n];
		List<Integer> res = new ArrayList<Integer>();
		int high = Integer.MAX_VALUE;
		ArrayList<Integer>[] matrix = new ArrayList[n];
		for (int i = 0; i < n; i++)
			matrix[i] = new ArrayList<Integer>();
		for (int i = 0; i < edges.length; i++) {
			matrix[edges[i][0]].add(edges[i][1]);
			matrix[edges[i][1]].add(edges[i][0]);
		}
		for (int i = 0; i < n; i++) {
			highs[i] = bfs(matrix, i, 1, high);
			high = Math.min(high, highs[i]);
		}
		for (int i = 0; i < n; i++)
			if (highs[i] == high)
				res.add(i);
		return res;
	}

	private int bfs(ArrayList<Integer>[] matrix, int k, int high, int minHigh) {
		int size = matrix[k].size();
		if (size == 0 || high > minHigh)
			return high;
		int res = high + 1;

		for (int i = 0; i < size; i++) {
			int next = matrix[k].remove(i);
			int index = matrix[next].indexOf(k);
			int prev = matrix[next].remove(index);
			res = Math.max(res, bfs(matrix, next, high + 1, minHigh));
			matrix[k].add(i, next);
			matrix[next].add(index, prev);
		}
		return res;
	}
}
