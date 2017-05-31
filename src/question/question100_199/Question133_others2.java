package question.question100_199;

import java.util.HashMap;
import help.UndirectedGraphNode;
//思路是一样的，在这道题上用DFS要比用BFS耗时低一些
public class Question133_others2 {
	private HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		return clone(node);
	}

	private UndirectedGraphNode clone(UndirectedGraphNode node) {
		if (node == null)
			return null;

		if (map.containsKey(node)) {
			return map.get(node);
		}
		UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
		map.put(node, clone);
		for (UndirectedGraphNode neighbor : node.neighbors) {
			clone.neighbors.add(clone(neighbor));
		}
		return clone;
	}
}
