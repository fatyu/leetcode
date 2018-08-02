package leetcode.algorithm._226;

/**
 *
 Invert a binary tree.
 Example:
 Input:
 4
 /   \
 2      7
 / \    / \
 1  3   6   9
 Output:
 4
 /   \
 7      2
 / \    / \
 9   6  3   1
 */
public class InvertBinaryTree {
    /* Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     * 解题思路通过临时对象进行左右节点对象调换，然后递归调用invert子节点
     */
    public TreeNode invert(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode result = null;
        TreeNode tmp = null;
        if (node.left == null && node.right == null) {
            return node;
        }
        tmp = node.left;
        node.left = node.right;
        node.right = tmp;
        invert(node.left);
        invert(node.right);
        return node;
    }


    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left
                = new TreeNode(2);
        node.left.left = new TreeNode(21);
        node.left.right = new TreeNode(22);
        node.right = new TreeNode(3);
        node.right.left = new TreeNode(31);
        node.right.right = new TreeNode(32);
        InvertBinaryTree tree = new InvertBinaryTree();
        TreeNode result =
                tree.invert(node);
    }
}
