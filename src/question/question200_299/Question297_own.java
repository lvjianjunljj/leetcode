package question.question200_299;

/*
 * Serialization is the process of converting a data structure or object into a sequence of bits 
 * so that it can be stored in a file or memory buffer, or transmitted across a network connection link 
 * to be reconstructed later in the same or another computer environment.
 * Design an algorithm to serialize and deserialize a binary tree. 
 * There is no restriction on how your serialization/deserialization algorithm should work. 
 * You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized 
 * to the original tree structure.
 * For example, you may serialize the following tree
 1
 / \
 2   3
 / \
 4   5
 as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. 
 You do not necessarily need to follow this format, so please be creative and come up 
 with different approaches yourself.
 Note: Do not use class member/global/static variables to store states. 
 Your serialize and deserialize algorithms should be stateless.
 */
import java.util.ArrayList;
import java.util.List;
import help.TreeNode;

//其实这道题并不难，读懂题意就行——就是让自己定义一种Tree和List的相互转换方式——对层序遍历进行稍微的修改就能实现这种相互转换
//其实用队列去实现层序遍历更好——但我一激动给忘了
public class Question297_own {
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null)
			return "n";
		List<TreeNode> list = new ArrayList<TreeNode>();
		list.add(root);
		StringBuilder sb = new StringBuilder();
		boolean notEnd = true;
		while (notEnd) {
			notEnd = false;
			List<TreeNode> tmp = new ArrayList<TreeNode>();
			for (TreeNode node : list)
				if (node != null) {
					notEnd = true;
					tmp.add(node.left);
					tmp.add(node.right);
				}
			if (notEnd) {
				for (TreeNode node : list) {
					if (node == null)
						sb.append("n,");
					else
						sb.append(node.val + ",");
				}
			}
			list = tmp;
		}
		return sb.deleteCharAt(sb.length() - 1).toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String[] list = data.split(",");
		if (list.length == 0 || list[0].equals("n"))
			return null;
		TreeNode root = new TreeNode(Integer.valueOf(list[0]));
		List<TreeNode> array = new ArrayList<TreeNode>();
		array.add(root);
		int i = 1;
		while (i < list.length) {
			if (i >= list.length)
				break;
			List<TreeNode> tmp = new ArrayList<TreeNode>();
			for (TreeNode node : array) {
				if (node != null) {
					node.left = list[i].equals("n") ? null : new TreeNode(
							Integer.valueOf(list[i]));
					i++;
					node.right = list[i].equals("n") ? null : new TreeNode(
							Integer.valueOf(list[i]));
					i++;
					tmp.add(node.left);
					tmp.add(node.right);
				}
			}
			array = tmp;
		}
		return root;
	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
