package binarytree;

import binarytree.base.TreeNode;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree

public class LowestCommonAncestor {
  class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      if (root == null || root == p || root == q) {
        return root;
      }
      TreeNode left = lowestCommonAncestor(root.left, p, q);
      TreeNode right = lowestCommonAncestor(root.right, p, q);
      if (left != null && right != null) {
        return root;
      }
      return left != null ? left : right;
    }
  }

  public static void main(String[] args) {
    // Build the tree and keep references to nodes 2 and 4
    TreeNode node4 = new TreeNode(4);
    TreeNode node6 = new TreeNode(6);
    TreeNode node7 = new TreeNode(7);
    TreeNode node5 = new TreeNode(5, node6, node7);
    TreeNode node2 = new TreeNode(2, node4, node5);
    TreeNode node9 = new TreeNode(9);
    TreeNode node8 = new TreeNode(8, node9, null);
    TreeNode node3 = new TreeNode(3, null, node8);
    TreeNode root = new TreeNode(1, node2, node3);

    TreeNode lca = new LowestCommonAncestor().new Solution().lowestCommonAncestor(root, node2, node4);
    System.out.println(lca.val); // Should print 2
  }
}
