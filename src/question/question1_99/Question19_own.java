package question.question1_99;

import help.ListNode;

/*
 * Given a linked list, remove the nth node from the end of list and return its head.
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 */
//很简单的一道题，没什么好说的，就是写的比较繁琐
//https://leetcode.com/discuss/32090/my-simple-java-solution-in-one-pass他写的就比较简单
public class Question19_own {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		int size = 1;
		ListNode cur = head;
		while (!(cur.next == null)) {
			cur = cur.next;
			size++;
		}
		if (size == 1)
			return null;
		if (size == 2) {
			if (n == 1)
				head.next = null;
			else
				head = head.next;
			return head;
		}
		if (size == n)
			return head.next;
		cur = head;
		for (int i = 0; i < size - n - 1; i++)
			cur = cur.next;
		cur.next = cur.next.next;
		return head;
	}
}
//ListNode在Question21中封装过了
