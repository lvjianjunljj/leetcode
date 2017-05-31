package question.question100_199;

/*
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 */
import java.util.HashMap;
import help.RandomListNode;
//question133的方法都无法使用，因为这道题的测试数据数据量很大，HashMap或者ArrayList都存储不下
public class Question138_own {
	HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();

	public RandomListNode copyRandomList(RandomListNode head) {
		copy(head);
		return map.get(head);
	}

	private RandomListNode copy(RandomListNode node) {
		if (node == null)
			return null;
		if (map.containsKey(node))
			return map.get(node);
		map.put(node, new RandomListNode(node.label));
		map.get(node).next = copy(node.next);
		map.get(node).random = copy(node.random);
		return map.get(node);
	}
}
