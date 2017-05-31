package question.question1_99;

/*
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * return 1->4->3->2->5->NULL.
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 */
import help.ListNode;

//写的太繁琐了，将m==1的情况单独列出来了，我得想个办法简练一下（其实本身并不是很麻烦，将边界条件想好就好了）
public class Question92_own1 {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (m == 1) {
			ListNode prev = null, cur = head;
			int k = 1;
			while (k <= n) {
				ListNode next = cur.next;
				cur.next = prev;
				prev = cur;
				cur = next;
				k++;
			}
			head.next = cur;
			return prev;
		}
		ListNode prev = head;
		int k = 2;
		while (k < m) {
			prev = prev.next;
			k++;
		}
		ListNode cur = prev.next, pre = null, curr = cur;
		while (k <= n) {
			ListNode next = curr.next;
			curr.next = pre;
			pre = curr;
			curr = next;
			k++;
		}
		cur.next = curr;
		prev.next = pre;
		return head;
	}
}
