package question.question100_199;

import help.ListNode;
//其实没有必要确定两个链表的长度，每一个链表都循环一周即到达了交接点
//若两个链表没有交点，则视为两个链表相交于最后一个点null
public class Question160_others2 {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;
		ListNode a = headA;
		ListNode b = headB;
		while (a != b) {
			a = a == null ? headB : a.next;
			b = b == null ? headA : b.next;
		}
		return a;
	}
}
