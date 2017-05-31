package question.question100_199;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import help.UndirectedGraphNode;

//用HashMap的键值对代替了own中两个数组检索的对应关系——确实降低了耗时
public class Question133_others1 {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null)
			return null;
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		map.put(node, new UndirectedGraphNode(node.label));
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		queue.add(node);
		while (!queue.isEmpty()) {
			UndirectedGraphNode host = queue.poll();
			List<UndirectedGraphNode> list = host.neighbors;
			for (UndirectedGraphNode neighbor : list) {
				if (!map.containsKey(neighbor)) {
					map.put(neighbor, new UndirectedGraphNode(neighbor.label));
					queue.add(neighbor);
				}
				map.get(host).neighbors.add(map.get(neighbor));
			}
		}
		return map.get(node);
	}
}
