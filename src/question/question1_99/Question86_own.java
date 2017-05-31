package question.question1_99;

import help.ListNode;

/*
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 For example,
 Given 1->4->3->2->5->2 and x = 3,
 return 1->2->2->4->3->5.
 */
//并不是很难，就是要封装一个point和cur，遇到比小的就向前提（链表做这个简单），封装一个mark是为了看是不是一开始的数就比x小。
public class Question86_own {
	public ListNode partition(ListNode head, int x) {
		ListNode first = new ListNode(1);
		first.next = head;
		ListNode cur = first;
		ListNode point = first;
		boolean mark = true;
		while (cur.next != null) {
			if (cur.next.val < x) {
				if (mark) {
					point = point.next;
					cur = cur.next;
				} else {
					ListNode next1 = cur.next;
					ListNode next2 = point.next;
					cur.next = next1.next;
					next1.next = next2;
					point.next = next1;
					point = point.next;
				}
			} else {
				mark = false;
				cur = cur.next;
			}
		}
		return first.next;
	}
}
