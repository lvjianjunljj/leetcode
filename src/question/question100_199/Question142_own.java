package question.question100_199;

import help.ListNode;

/*
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 */
//之前遇到过这个题，就是求欧拉环的起点（Question287）
public class Question142_own {
	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null)
			return null;
		ListNode slow = head.next;
		ListNode fast = head.next.next;
		while (slow != null && fast != null && fast.next != null
				&& slow != fast) {
			slow = slow.next;
			fast = fast.next.next;
		}
		if (slow == fast) {
			slow = head;
			while (slow != fast) {
				slow = slow.next;
				fast = fast.next;
			}
			return slow;
		} else {
			return null;
		}
	}
}

