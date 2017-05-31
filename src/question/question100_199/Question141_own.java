package question.question100_199;

import help.ListNode;

/*
 * Given a linked list, determine if it has a cycle in it.
 *  Follow up:
 *  Can you solve it without using extra space?
 */
//很简单，一快一慢最终相遇就是有环的
public class Question141_own {
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null)
			return false;
		ListNode slow = head.next;
		ListNode fast = head.next.next;
		while (slow != null && fast != null && fast.next != null
				&& slow != fast) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow == fast;
	}
}

