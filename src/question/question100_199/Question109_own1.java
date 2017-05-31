package question.question100_199;

/*
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 */
import help.ListNode;
import help.TreeNode;

//想用108的分治方法，但是找链表的中间节点太耗时间了，肯定超时
public class Question109_own1 {
	public TreeNode sortedListToBST(ListNode head) {
		return aux(head, null);
	}

	private TreeNode aux(ListNode head, ListNode end) {
		if (head == null || (end != null && end.next == head))
			return null;
		if (head == end)
			return new TreeNode(head.val);
		ListNode fast = head;
		ListNode slow = head;
		ListNode prev = new ListNode(0);
		prev.next = head;
		while (fast != end && fast.next != end) {
			fast = fast.next.next;
			prev = slow;
			slow = slow.next;
		}
		TreeNode res = new TreeNode(slow.val);
		res.left = aux(head, prev);
		res.right = aux(slow.next, end);
		return res;
	}
}
