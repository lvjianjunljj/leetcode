package question.question1_99;

import help.ListNode;

//这样写更简洁一些
public class Question21_own2 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0), cur = prev;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            } else {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            }
        }
        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }
        return prev.next;
    }
}
