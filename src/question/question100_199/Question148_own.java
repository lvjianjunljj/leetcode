package question.question100_199;
/*
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
import help.ListNode;
//用数组的快排方法去给链表排序，好事果然高的不行。
public class Question148_own {
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode cur = head;
		while (cur.next != null)
			cur = cur.next;
		partition(head, cur);
		return head;
	}

	private void partition(ListNode start, ListNode end) {
		if (start == end || end == null || end.next == start)
			return;
		int x = end.val;
		ListNode temp = start;
		ListNode cur = start;
		ListNode prev = start;
		while (temp != end) {
			if (temp.val < x) {
				tran(temp, cur);
				prev = cur;
				cur = cur.next;

			}
			temp = temp.next;
		}
		tran(cur, end);
		partition(start, prev);
		partition(cur.next, end);
	}

	private void tran(ListNode node1, ListNode node2) {
		int temp = node1.val;
		node1.val = node2.val;
		node2.val = temp;
	}
}
