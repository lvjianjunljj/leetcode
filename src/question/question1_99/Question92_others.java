package question.question1_99;

import help.ListNode;

//这个for循环写的还是漂亮，让我了解了另一种链表反转的方法
public class Question92_others {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null)
			return null;
		ListNode root = new ListNode(0);
		root.next = head;
		ListNode prev = root;
		for (int i = 1; i < m; i++)
			prev = prev.next;
		ListNode cur = prev.next, after = cur.next;
		for (int i = 0; i < n - m; i++) {
			cur.next = after.next;
			after.next = prev.next;
			prev.next = after;
			after = cur.next;
		}
		return root.next;
	}
}
