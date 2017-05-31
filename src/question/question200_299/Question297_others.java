package question.question200_299;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import help.TreeNode;

//其实对先序遍历稍加修改也是能实现的（还是递归写起来舒服）
//这里由String到Tree的转换还是用到了Queue，不然index是不好维护的
public class Question297_others {
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		buildString(root, sb);
		return sb.deleteCharAt(sb.length() - 1).toString();
	}

	private void buildString(TreeNode node, StringBuilder sb) {
		if (node == null)
			sb.append("n,");
		else {
			sb.append(node.val + ",");
			buildString(node.left, sb);
			buildString(node.right, sb);
		}
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		Queue<String> queue = new LinkedList<String>();
		queue.addAll(Arrays.asList(data.split(",")));
		TreeNode root = buildTree(queue);
		return root;
	}

	private TreeNode buildTree(Queue<String> queue) {
		if (queue.isEmpty())
			return null;
		String tmp = queue.poll();
		if (tmp.equals("n"))
			return null;
		TreeNode node = new TreeNode(Integer.valueOf(tmp));
		node.left = buildTree(queue);
		node.right = buildTree(queue);
		return node;
	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
