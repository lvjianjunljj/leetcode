package question.question200_299;

import help.TreeNode;
import java.util.ArrayList;
import java.util.List;

//用List<Boolean>存储p和q的路径然后再去比较——耗时还是有点高——要用回溯遍历两遍，确实有点麻烦
public class Question236_own2 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		List<Boolean> path1 = new ArrayList<Boolean>();
		List<Boolean> path2 = new ArrayList<Boolean>();
		search(root, path1, p);
		search(root, path2, q);
		int i = 0;
		TreeNode cur = root;
		while (i < Math.min(path1.size(), path2.size())
				&& path1.get(i) == path2.get(i)) {
			cur = path1.get(i) ? cur.left : cur.right;
			i++;
		}
		return cur;
	}

	private boolean search(TreeNode node, List<Boolean> path, TreeNode p) {
		if (node == p)
			return true;
		if (node == null)
			return false;
		path.add(true);
		if (search(node.left, path, p))
			return true;
		path.remove(path.size() - 1);
		path.add(false);
		if (search(node.right, path, p))
			return true;
		path.remove(path.size() - 1);
		return false;
	}
}
