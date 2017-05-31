package question.question100_199;

/*
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 * OJ's undirected graph serialization:
 * Nodes are labeled uniquely.
 * We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 * As an example, consider the serialized graph {0,1,2#1,2#2,2}.
 * The graph has a total of three nodes, and therefore contains three parts as separated by #.
 * First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 * Second node is labeled as 1. Connect node 1 to node 2.
 * Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 * Visually, the graph looks like the following:

 1
 / \
 /   \
 0 --- 2
 / \
 \_/
 */
import java.util.ArrayList;
import java.util.List;
import help.UndirectedGraphNode;
//因为涉及到点的neighbors可能包含之前的点，所以不能一直建新的点，所以每次还要有一个查找前点的过程，比较耗时
public class Question133_own {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null)
			return null;
		UndirectedGraphNode res = new UndirectedGraphNode(node.label);
		ArrayList<UndirectedGraphNode> setOri = new ArrayList<UndirectedGraphNode>();
		ArrayList<UndirectedGraphNode> setCopy = new ArrayList<UndirectedGraphNode>();
		copy(setOri, setCopy, node, res);
		return res;
	}

	private void copy(ArrayList<UndirectedGraphNode> setOri,
			ArrayList<UndirectedGraphNode> setCopy, UndirectedGraphNode node,
			UndirectedGraphNode copyNode) {
		setOri.add(node);
		setCopy.add(copyNode);
		List<UndirectedGraphNode> list = node.neighbors;
		while (list.size() > 0) {
			UndirectedGraphNode next = list.remove(0);
			UndirectedGraphNode copyNext = new UndirectedGraphNode(next.label);
			if (setOri.indexOf(next) >= 0)
				copyNext = setCopy.get(setOri.indexOf(next));
			if (copyNext.neighbors.indexOf(node) > -1)
				copyNext.neighbors.remove(copyNext.neighbors.indexOf(node));
			copyNode.neighbors.add(copyNext);
			if (setOri.indexOf(next) < 0)
				copy(setOri, setCopy, next, copyNext);
		}
	}
}
