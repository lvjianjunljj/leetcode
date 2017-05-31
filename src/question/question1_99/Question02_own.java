package question.question1_99;

import help.ListNode;

/*
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
//应该还能简化一下代码，但我懒得看了，挺简单的，不用反转链表，链表的头就表示个位
public class Question02_own {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		boolean carry = false, first = true;
		ListNode cur1 = l1;
		ListNode cur2 = l2;
		ListNode end1 = cur1;
		ListNode end2 = cur2;
		while (cur1 != null || cur2 != null) {
			if (cur1 == null)
				first = false;
			else
				first = true;
			cur1 = cur1 != null ? cur1 : new ListNode(0);
			cur2 = cur2 != null ? cur2 : new ListNode(0);
			int sum = cur1.val + cur2.val + (carry ? 1 : 0);
			carry = sum > 9;
			cur1.val = sum % 10;
			cur2.val = sum % 10;
			end1 = cur1;
			end2 = cur2;
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		if (carry) {
			end1.next = new ListNode(1);
			end2.next = new ListNode(1);
		}
		if (first)
			return l1;
		else
			return l2;
	}
}
