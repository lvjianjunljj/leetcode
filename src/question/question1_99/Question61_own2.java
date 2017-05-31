package question.question1_99;

import help.ListNode;

//精简一下代码
public class Question61_own2 {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null || k < 1) {
			return head;
		}
		int len = 0;
		ListNode prev = null, cur = head;
		while (cur != null) {
			prev = cur;
			cur = cur.next;
			len++;
		}
		int next = len - (k % len);
		prev.next = head;
		prev = null;
		while (next > 0) {
			prev = head;
			head = head.next;
			next--;
		}
		prev.next = null;
		return head;
	}
}
