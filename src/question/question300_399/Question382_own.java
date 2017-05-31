package question.question300_399;

/*
 * Given a singly linked list, return a random node's value from the linked list. 
 * Each node must have the same probability of being chosen.
 * Follow up:
 * What if the linked list is extremely large and its length is unknown to you? 
 * Could you solve this efficiently without using extra space?
 * Example:
 * // Init a singly linked list [1,2,3].
 * ListNode head = new ListNode(1);
 * head.next = new ListNode(2);
 * head.next.next = new ListNode(3);
 * Solution solution = new Solution(head);
 * // getRandom() should return either 1, 2, or 3 randomly. 
 * Each element should have equal probability of returning.
 * solution.getRandom();
 */
import help.ListNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//为了防止数组中的存储的ListNode过多溢出，采取链表中每三个存储一个点，随机取的时候再根据分隔取就行——耗时还是有一点高
public class Question382_own {
	List<ListNode> flags = new ArrayList<ListNode>();
	int n = 0;

	/**
	 * @param head
	 *            The linked list's head. Note that the head is guaranteed to be
	 *            not null, so it contains at least one node.
	 */
	public Question382_own(ListNode head) {
		ListNode cur = head;
		while (cur != null) {
			if (n++ % 3 == 0)
				flags.add(cur);
			cur = cur.next;
		}
	}

	/** Returns a random node's value. */
	public int getRandom() {
		Random ra = new Random();
		int index = ra.nextInt(n);
		ListNode flag = flags.get(index / 3);
		for (int i = 0; i < index % 3; i++)
			flag = flag.next;
		return flag.val;
	}
}
