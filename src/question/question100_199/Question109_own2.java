package question.question100_199;

import java.util.HashMap;
import help.ListNode;
import help.TreeNode;
//实在想不到什么取中间节点的好方法，只能用HashMap将其封装成类似于数组的数值和坐标对来进行分治——耗时很高
public class Question109_own2 {
	public TreeNode sortedListToBST(ListNode head) {
		HashMap<Integer, ListNode> map = new HashMap<Integer, ListNode>();
		int i = 0;
		while (head != null) {
			map.put(i++, head);
			head = head.next;
		}
		return aux(map, 0, i - 1);
	}

	private TreeNode aux(HashMap<Integer, ListNode> map, int i, int j) {
		if (i > j)
			return null;
		if (i == j)
			return new TreeNode(map.get(i).val);
		int mid = (i + j) / 2;
		TreeNode res = new TreeNode(map.get(mid).val);
		res.left = aux(map, i, mid - 1);
		res.right = aux(map, mid + 1, j);
		return res;
	}
}
