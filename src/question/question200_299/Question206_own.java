package question.question200_299;

/*
 * Reverse a singly linked list.
 */
import help.ListNode;

//反转单向链表，很简单。
public class Question206_own {
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode prev = head;
		ListNode cur = head.next;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		head.next = null;
		return prev;
	}
}
