package leetcode._104;

/**
 * Created by fatyu on 15/2/1.
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        return calcMaxDepth(root, 0);


    }

    public int calcMaxDepth(TreeNode node, int currentDepth) {
        if (null == node) {
            return currentDepth;
        }
        if (node.left == null && node.right == null) {
            return currentDepth + 1;
        }
        if (node.left != null && node.right == null) {
            return calcMaxDepth(node.left, currentDepth + 1);
        }
        if (node.left == null && node.right != null) {
            return calcMaxDepth(node.right, currentDepth + 1);
        }
        if (node.left != null && node.right != null) {
            int left = calcMaxDepth(node.left, currentDepth + 1);
            int right = calcMaxDepth(node.right, currentDepth + 1);
            return left > right ? left : right;
        }
        return currentDepth;
    }


}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}



