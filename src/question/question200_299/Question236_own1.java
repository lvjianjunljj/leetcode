package question.question200_299;

/*
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

 _______3______
 /              \
 ___5__          ___1__
 /      \        /      \
 6      _2       0       8
 /  \
 7   4
 For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 */
import help.TreeNode;
import java.util.HashSet;

//我遍历每个点，然后将其左右树的所有的点分别存储在HashSet中，耗时极高——超时了
public class Question236_own1 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return null;
		HashSet<TreeNode> left = new HashSet<TreeNode>();
		HashSet<TreeNode> right = new HashSet<TreeNode>();
		left.add(root);
		right.add(root);
		integrate(left, root.left);
		integrate(right, root.right);
		if ((left.contains(p) && right.contains(q))
				|| (left.contains(q) && right.contains(p)))
			return root;
		else if (left.contains(p))
			return lowestCommonAncestor(root.left, p, q);
		else
			return lowestCommonAncestor(root.right, p, q);
	}

	private void integrate(HashSet<TreeNode> set, TreeNode node) {
		if (node == null)
			return;
		set.add(node);
		integrate(set, node.left);
		integrate(set, node.right);
	}
}
