package question.question100_199;

import help.ListNode;
//聊表的排序就可以用分治了嘛，因为完全不需要用到多余的空间——写merge方法完全不用重新建一个数组，直接组合两个链表就行了啊
public class Question148_others {
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode slow = head, fast = head.next.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode second = sortList(slow.next);
		slow.next = null;
		return merge(sortList(head), second);
	}

	private ListNode merge(ListNode node1, ListNode node2) {
		ListNode prev = new ListNode(0);
		ListNode cur = prev, cur1 = node1, cur2 = node2;
		while (cur1 != null && cur2 != null) {
			if (cur1.val < cur2.val) {
				cur.next = cur1;
				cur1 = cur1.next;
			} else {
				cur.next = cur2;
				cur2 = cur2.next;
			}
			cur = cur.next;
		}
		if (cur1 == null)
			cur.next = cur2;
		else
			cur.next = cur1;
		return prev.next;
	}
}
