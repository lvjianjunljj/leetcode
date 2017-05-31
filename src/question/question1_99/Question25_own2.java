package question.question1_99;

import help.ListNode;

//结合24题然后再加上一个自己封装的反转链表一下就出来了，其实蛮简单的
public class Question25_own2 {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (k < 2 || head == null) {
			return head;
		}
		ListNode cur = head;
		for (int i = 1; i < k; i++) {
			cur = cur.next;
			if (cur == null) {
				return head;
			}
		}
		ListNode next = cur.next;
		cur.next = null;
		ListNode res = reverse(head);
		head.next = reverseKGroup(next, k);
		return res;
	}

	private ListNode reverse(ListNode head) {
		ListNode prev = null, cur = head;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}
}
