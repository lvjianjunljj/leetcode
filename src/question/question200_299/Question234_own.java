package question.question200_299;

/*
 * Given a singly linked list, determine if it is a palindrome.
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
//由中间截开，将后面的链表反转然后比较——很简单
public class Question234_own {
	public boolean isPalindrome(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode prev = null;
		ListNode cur = slow;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		while (prev != null && head != null) {
			if (prev.val != head.val)
				return false;
			prev = prev.next;
			head = head.next;
		}
		return true;
	}
}
