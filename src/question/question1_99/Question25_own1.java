package question.question1_99;


/*
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 For example,
 Given this linked list: 1->2->3->4->5
 For k = 2, you should return: 2->1->4->3->5
 For k = 3, you should return: 3->2->1->4->5
 */
import help.ListNode;

import java.util.ArrayList;
//阶段反转链表，把我做恶心了，不看了
public class Question25_own1 {
	public ListNode reverseKGroup(ListNode head, int k) {
		ArrayList<ListNode> heads = new ArrayList<ListNode>();
		ArrayList<ListNode> ends = new ArrayList<ListNode>();
		int len = 0;
		ListNode cur = head;
		while (cur != null) {
			len++;
			cur = cur.next;
		}
		int freq = len / k;
		if (freq == 0 || k == 1)
			return head;
		ListNode prev = head;
		cur = head.next;
		for (int i = 0; i < freq; i++) {
			for (int j = 0; j < k - 1; j++) {
				if (j == 0)
					ends.add(prev);
				ListNode next = cur.next;
				cur.next = prev;
				prev = cur;
				if (j >= k - 2)
					heads.add(cur);
				cur = next;
			}
			if (i < freq - 1 && cur != null && cur.next != null) {
				prev = cur;
				cur = cur.next;
			}
		}
		heads.add(cur);
		for (int i = 0; i < freq; i++) {
			ends.get(i).next = heads.get(i + 1);
		}
		return heads.get(0);
	}
}
