package question.question100_199;

import java.util.HashMap;

//只能自己维护一个双向链表才能做到删除操作O1时间内完成，其实思想还是非常简单的
public class Question146_others {

	class Node {

		int key;
		int value;
		Node prev;
		Node next;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
			prev = null;
			next = null;
		}
	}

	int capacity, count;
	Node head, end;
	HashMap<Integer, Node> map;

	public Question146_others(int capacity) {
		this.capacity = capacity;
		map = new HashMap<Integer, Node>();
		head = new Node(0, 0);
		end = new Node(0, 0);
		head.next = end;
		end.prev = head;
		count = 0;
	}

	public int get(int key) {
		if (!map.containsKey(key))
			return -1;
		Node node = map.get(key);
		delete(node);
		add(node);
		return node.value;
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			node.value = value;
			delete(node);
			add(node);
		} else {
			if (count < capacity) {
				count++;
				Node node = new Node(key, value);
				map.put(key, node);
				add(node);
			} else {
				map.remove(head.next.key);
				delete(head.next);
				Node node = new Node(key, value);
				map.put(key, node);
				add(node);
			}
		}
	}

	private void delete(Node node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}

	private void add(Node node) {
		end.prev.next = node;
		node.prev = end.prev;
		end.prev = node;
		node.next = end;
	}
}
