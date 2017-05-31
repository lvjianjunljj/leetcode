package question.question100_199;
//其实算出两个链表的长度以后，将其末尾对齐然后向后移，就能找到交点。
import help.ListNode;

public class Question160_others1 {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int lenA = getLen(headA), lenB = getLen(headB);
		while (lenA > lenB) {
			headA = headA.next;
			lenA--;
		}
		while (lenA < lenB) {
			headB = headB.next;
			lenB--;
		}
		while (headA != headB) {
			headA = headA.next;
			headB = headB.next;
		}
		return headA;
	}

	private int getLen(ListNode head) {
		int res = 0;
		while (head != null) {
			head = head.next;
			res++;
		}
		return res;
	}
}
