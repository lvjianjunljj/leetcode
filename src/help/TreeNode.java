package help;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		val = x;
	}

	//封装好的toString方法，打印出树的前序中序后序三种遍历结果
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("前序遍历：{" + val);
		before(left);
		before(right);
		sb.append(before);
		sb.append("}\n");
		sb.append("中序遍历：{");
		inter(left);
		inter.append(val + " ");
		inter(right);
		sb.append(inter);
		sb.deleteCharAt(sb.length() - 1);
		sb.append("}\n");
		sb.append("后序遍历：{");
		after(left);
		after(right);
		sb.append(after);
		sb.append(val);
		sb.append("}");
		return sb.toString();
	}

	StringBuilder before = new StringBuilder();
	StringBuilder inter = new StringBuilder();
	StringBuilder after = new StringBuilder();

	private void before(TreeNode node) {
		if (node != null) {
			before.append(" " + node.val);
			before(node.left);
			before(node.right);
		}
	}

	private void inter(TreeNode node) {
		if (node != null) {
			inter(node.left);
			inter.append(node.val + " ");
			inter(node.right);
		}
	}

	private void after(TreeNode node) {
		if (node != null) {
			after(node.left);
			after(node.right);
			after.append(node.val + " ");
		}
	}
}
