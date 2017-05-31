package help;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
		next = null;
	}

	// 封装的通过数组直接转换成链表的方法
	public ListNode(int[] nums) {
		val = nums[0];
		if (nums.length < 2)
			return;
		next = new ListNode(nums[1]);
		ListNode cur = next;
		for (int i = 2; i < nums.length; i++) {
			cur.next = new ListNode(nums[i]);
			cur = cur.next;
		}
	}

	// 封装的toString方法
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{ " + val);
		ListNode cur = next;
		while (cur != null) {
			sb.append(", " + cur.val);
			cur = cur.next;
		}
		sb.append(" }");
		return sb.toString();
	}
}