package question.question300_399;

/*
 * Equations are given in the format A / B = k, where A and B are variables represented as strings, 
 * and k is a real number (floating point number). Given some queries, return the answers. 
 * If the answer does not exist, return -1.0.
 * Example:
 * Given a / b = 2.0, b / c = 3.0. 
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? . 
 * return [6.0, 0.5, -1.0, 1.0, -1.0 ].
 * The input is: vector<pair<string, string>> equations, vector<double>& values, 
 * vector<pair<string, string>> queries , where equations.size() == values.size(), 
 * and the values are positive. This represents the equations. Return vector<double>.
 * According to the example above:
 * equations = [ ["a", "b"], ["b", "c"] ],
 * values = [2.0, 3.0],
 * queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 
 */
import java.util.HashMap;

//看了提示才知道是要用图算法做，用最简单的BFS就能实现，就是要自己封装类——答案暂时没给什么好的方法，以后再看看吧
public class Question399_own {
	class Node {

		String name;
		HashMap<Node, Double> next;
		boolean visited = false;

		public Node(String name) {
			this.name = name;
			next = new HashMap<Node, Double>();
		}

		public void addNext(Node node, double quot) {
			next.put(node, quot);
		}

		public double search(String nextName) {
			if (name.equals(nextName))
				return 1.0;
			visited = true;
			for (Node node : next.keySet())
				if (!node.visited && node.search(nextName) > -1.0) {
					visited = false;
					return next.get(node) * node.search(nextName);
				}
			visited = false;
			return -1.0;
		}
	}

	public double[] calcEquation(String[][] equations, double[] values,
			String[][] queries) {
		HashMap<String, Node> map = new HashMap<String, Node>();
		for (int i = 0; i < equations.length; i++) {
			if (!map.containsKey(equations[i][0]))
				map.put(equations[i][0], new Node(equations[i][0]));
			if (!map.containsKey(equations[i][1]))
				map.put(equations[i][1], new Node(equations[i][1]));
			map.get(equations[i][0]).addNext(map.get(equations[i][1]),
					values[i]);
			map.get(equations[i][1]).addNext(map.get(equations[i][0]),
					1.0 / values[i]);
		}
		double[] res = new double[queries.length];
		for (int i = 0; i < queries.length; i++)
			res[i] = map.containsKey(queries[i][0]) ? map.get(queries[i][0])
					.search(queries[i][1]) : -1.0;
		return res;
	}
}
