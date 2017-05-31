package question.question1_99;

import help.ListNode;

//一开始想用递归的，可是没太想明白，果然还是直接调用主方法本身的递归最简单啊
public class Question24_others1 {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode next = head.next;
		head.next = swapPairs(head.next.next);
		next.next = head;
		return next;
	}
}
