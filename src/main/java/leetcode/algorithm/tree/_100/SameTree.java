package leetcode.algorithm.tree._100;

import leetcode.algorithm.tree._226.TreeNode;

/**
 Given two binary trees, write a function to check if they are the same or not.
 Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 Example 1:
 Input:
 1         1
 / \       / \
 2   3     2   3
 [1,2,3],   [1,2,3]
 Output: true

 Example 2:
 Input:
 1         1
 /           \
 2             2
 [1,2],     [1,null,2]
 Output: false

 Example 3:
 Input:
 1         1
 / \       / \
 2   1     1   2
 [1,2,1],   [1,1,2]
 Output: false
 */
public class SameTree {

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p != null && q != null) {
			if (p.val != q.val) {
				return false;
			}
		} else if (p == null && q == null) {
			return true;
		} else {
			return false;
		}
		if (!isSameTree(p.left, q.left))
			return false;
		if (!isSameTree(p.right, q.right))
			return false;
		return true;
	}

	public static void main(String[] args) {
		TreeNode p = new TreeNode(0);
		p.left = new TreeNode(-5);

		TreeNode q = new TreeNode(0);

		q.left = new TreeNode(-8);
		SameTree st = new SameTree();
		System.out.println(st.isSameTree(p, q));

	}

}


