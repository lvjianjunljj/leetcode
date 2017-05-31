package question.question100_199;
/*
 * Sort a linked list using insertion sort.
 */
import help.ListNode;
//一般需要建立一个前置的ListNode，这样插入排序可以在该ListNode之后进行不然插入到第一个的操作不好进行
public class Question147_own {
	public ListNode insertionSortList(ListNode head) {
		ListNode prev = new ListNode(Integer.MIN_VALUE);
		while (head != null) {
			ListNode cur = prev;
			while (cur.next != null && cur.next.val < head.val)
				cur = cur.next;
			ListNode next = head.next;
			head.next = cur.next;
			cur.next = head;
			head = next;
		}
		return prev.next;
	}
}
