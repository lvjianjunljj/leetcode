package question.question200_299;
/*
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.
 */
//既然不能用prev，那就只能操作值了
public class Question237 {
	public void deleteNode(ListNode node) {
		while (node.next.next != null) {
			node.val = node.next.val;
			node = node.next;
		}
		node.val = node.next.val;
		node.next = null;
	}
}
