package question.question300_399;

/*
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 * Example:
 * Given 1->2->3->4->5->NULL,
 * return 1->3->5->2->4->NULL.
 */
import help.ListNode;
//很简单的题，没什么好说的，就是把链表拆分一下在整合
public class Question328_own {
	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode odd = head;
		ListNode second = head.next;
		ListNode even = second;
		while (odd.next != null && even.next != null) {
			odd.next = even.next;
			even.next = even.next.next;
			odd = odd.next;
			even = even.next;
		}
		odd.next = second;
		return head;
	}
}
