package question.question100_199;

import help.ListNode;
import help.TreeNode;
//这个方法简直是美妙，遍历一遍链表就结束了，封装出一个成员变量，分值的过程中直接遍历其一遍就行——先求左树再取值再求右树
public class Question109_others {

	private ListNode node;

	public TreeNode sortedListToBST(ListNode head) {
		node = head;
		int size = 0;
		while (head != null) {
			size++;
			head = head.next;
		}
		return aux(0, size - 1);
	}

	private TreeNode aux(int i, int j) {
		if (i > j)
			return null;
		int mid = (i + j) / 2;
		TreeNode res = new TreeNode(0);
		res.left = aux(i, mid - 1);
		res.val = node.val;
		//这一步简直是超神
		node = node.next;
		res.right = aux(mid + 1, j);
		return res;
	}
}
