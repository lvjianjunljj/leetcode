package question.question1_99;

import help.ListNode;
//没看到链表是已经排好序的，那就好做多了
public class Question83_own2 {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode cur = head.next;
		ListNode prev = head;
		while (cur != null) {
			if (cur.val != prev.val)
				prev = prev.next;
			else
				prev.next = cur.next;
			cur = cur.next;
		}
		return head;
	}
}
