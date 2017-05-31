package question.question1_99;

import help.ListNode;

/*
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
//虽然方法非常粗暴，便利了两遍原链表，但是测试数据不大，耗时还是0ms
public class Question24_own {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode first = head;
		ListNode curF = first;
		ListNode second = head.next;
		ListNode curS = second;
		while (curS != null) {
			ListNode nextF = curS.next;
			ListNode nextS = curS.next != null ? curS.next.next : null;
			curF.next = nextF;
			curS.next = nextS;
			curF = curF.next;
			curS = curS.next;
		}
		curF = first;
		curS = second;
		while (curS != null) {
			ListNode nextS = curS.next;
			ListNode nextF = curF.next;
			curS.next = curF;
			curF.next = nextS != null ? nextS : nextF;
			curS = nextS;
			curF = nextF;
		}
		return second;
	}
}
