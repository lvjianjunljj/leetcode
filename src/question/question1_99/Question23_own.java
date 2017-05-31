package question.question1_99;

/*
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
import help.ListNode;
import java.util.Arrays;
import java.util.Comparator;
//每次取出一个值然后立即排序肯定是不行的，所以就找个小技巧可以大大降低耗时，但是确实不是最正统方法
//技巧——如果去除该链表的这个值以后它的next为空，则直接继续向下取。
public class Question23_own {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0)
			return null;
		Comparator<ListNode> c = new Comparator<ListNode>() {
			public int compare(ListNode node1, ListNode node2) {
				if (node1 == null && node2 == null)
					return 0;
				if (node1 == null)
					return 1;
				if (node2 == null)
					return -1;
				if (node1.val > node2.val)
					return 1;
				else if (node1.val < node2.val)
					return -1;
				else
					return 0;
			}
		};
		ListNode prev = new ListNode(0);
		ListNode cur = prev;
		Arrays.sort(lists, c);
		int i = 0;
		while (i < lists.length && lists[i] != null) {
			cur.next = new ListNode(lists[i].val);
			lists[i] = lists[i].next;
			if (lists[i] == null)
				i++;
			else {
				Arrays.sort(lists, c);
				i = 0;
			}
			cur = cur.next;
		}
		return prev.next;
	}
}
