package question.question100_199;
/*
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * For example, the following two linked lists:
 * 
A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.
 */
import help.ListNode;

//之前接触过这个方法，用欧拉环做，这是我能想到的最快的方法了
public class Question160_own {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode aCur = headA;
        if (headA == null || headB == null)
            return null;
		while (aCur.next != null)
			aCur = aCur.next;
		aCur.next = headB;
		ListNode slow = headA.next;
		ListNode fast = headA.next.next;
		while (fast != null && fast.next != null && slow != fast) {
			fast = fast.next.next;
			slow = slow.next;
		}
		if (slow != fast) {
		    aCur.next = null;
			return null;
		}
		fast = headA;
		while (fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		aCur.next = null;
		return fast;
    }
}
