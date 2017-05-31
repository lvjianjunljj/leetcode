package question.question1_99;

import help.ListNode;
//这种递归简洁而好看，它取的是每一串重复的数的最后一个
public class Question83_others {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		head.next = deleteDuplicates(head.next);
		return head.val == head.next.val ? head.next : head;
	}
}
