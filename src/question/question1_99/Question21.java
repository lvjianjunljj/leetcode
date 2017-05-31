package question.question1_99;

import help.ListNode;
/*
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 */

//直接舍弃head这个点从下一个作为结果输出，这样直接省去了判断两个链表都为空的情况
public class Question21 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode current = head;
		while (l1 != null && l2 != null) {
			if (l1.val > l2.val) {
				current.next = l2;
				current = current.next;
				l2 = l2.next;
			} else {
				current.next = l1;
				current = current.next;
				l1 = l1.next;
			}
		}
		if (l1 == null) {
			while (l2 != null) {
				current.next = l2;
				current = current.next;
				l2 = l2.next;
			}
		} else {
			while (l1 != null) {
				current.next = l1;
				current = current.next;
				l1 = l1.next;
			}
		}
		return head.next;
	}

}
