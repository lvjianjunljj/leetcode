package question.question200_299;

/*
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 You must do this in-place without altering the nodes' values.
 For example,
 Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */
//并不是很难，找到中间点就行
public class Question143_own {
	public void reorderList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null)
			return;
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		if (fast != null && fast.next == null)
			slow = slow.next;
		ListNode prev = slow;
		ListNode cur = slow.next;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		slow.next = null;
		ListNode first = head;
		ListNode second = prev;
		while (first != null && second != null) {
			ListNode next1 = first.next;
			ListNode next2 = second.next;
			first.next = second;
			second.next = next1;
			first = next1;
			second = next2;
		}
		first.next = second;
	}
}
