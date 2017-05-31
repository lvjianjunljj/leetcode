package question.question1_99;

/*
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */
import help.ListNode;

import java.util.HashSet;

//我能想到的办法就是将数都存到HashSet中，不是第一次出现的就直接将其在链表中剔除——剔除对应值的点这个方法之前写过
public class Question83_own1 {
	public ListNode deleteDuplicates(ListNode head) {
		HashSet<Integer> set = new HashSet<Integer>();
		ListNode cur = head;
		ListNode prev = new ListNode(0);
		prev.next = head;
		while (cur != null) {
			if (set.add(cur.val))
				prev = prev.next;
			else
				prev.next = cur.next;
			cur = cur.next;
		}
		return head;
	}
}
