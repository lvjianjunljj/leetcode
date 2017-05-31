package question.question1_99;

import help.ListNode;

/*
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * For example:
 Given 1->2->3->4->5->NULL and k = 2,
 return 4->5->1->2->3->NULL.
 */
//还是很简单的，没什么难度
public class Question61_own {
	public ListNode rotateRight(ListNode head, int k) {
		int len = 0;
		ListNode cur = head;
		while (cur != null) {
			len++;
			cur = cur.next;
		}
		if (head == null || head.next == null || k % len == 0)
			return head;
		int step = (len - k % len) % len;
		cur = head;
		ListNode end = null;
		for (int i = 0; i < step; i++) {
			if (i == step - 1)
				end = cur;
			cur = cur.next;
		}
		ListNode res = cur;
		if (cur == null)
			return head;
		while (cur.next != null)
			cur = cur.next;
		cur.next = head;
		if (end != null)
			end.next = null;
		return res;
	}
}
