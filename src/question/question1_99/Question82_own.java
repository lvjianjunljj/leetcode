package question.question1_99;
/*
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 */
import java.util.HashMap;
import help.ListNode;
//我的方法是将所有的点存储到HashMap中，然后重复的标示一下，重新遍历链表将重复的点全部剔除
public class Question82_own {
	public ListNode deleteDuplicates(ListNode head) {
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		ListNode cur = head;
		while (cur != null) {
			if (map.containsKey(cur.val))
				map.put(cur.val, false);
			else
				map.put(cur.val, true);
			cur = cur.next;
		}
		ListNode orig = new ListNode(0);
		orig.next = cur = head;
		ListNode prev = orig;
		while (cur != null) {
			if (map.get(cur.val))
				prev = prev.next;
			else
				prev.next = cur.next;
			cur = cur.next;
		}
		return orig.next;
	}
}
