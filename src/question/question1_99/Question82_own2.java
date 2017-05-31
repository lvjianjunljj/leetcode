package question.question1_99;

import help.ListNode;
//既然是排好序的就好做了，相比于83区别就是这个点只要是和他前面的或者后面的点相同就不要了，尊群这个规则就能把所有重复点去掉
public class Question82_own2 {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode cur = head;
		ListNode orig = new ListNode(head.val + 1);
		orig.next = cur = head;
		ListNode prev = orig;
		ListNode before = orig;
		while (cur != null) {
			if (cur.val != before.val
					&& (cur.next == null || cur.val != cur.next.val))
				prev = prev.next;
			else
				prev.next = cur.next;
			before = cur;
			cur = cur.next;
		}
		return orig.next;
	}
}
