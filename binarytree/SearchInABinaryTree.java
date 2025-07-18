package binarytree;

// (problem statement or link here if needed)

import binarytree.base.TreeNode;

public class SearchInABinaryTree {
  static class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
      return inOrderTraversal(root, val);
    }

    private TreeNode inOrderTraversal(TreeNode root, int val) {
      if (root == null) {
        return null;
      }

      if (root.val == val) {
        return root;
      }

      final TreeNode leftResult = inOrderTraversal(root.left, val);
      if (leftResult != null) {
        return leftResult;
      }

      final TreeNode rightResult = inOrderTraversal(root.right, val);
      return rightResult;
    }
  }

  public static void main(String[] args) {
    final TreeNode tree = new TreeNode(18,
        new TreeNode(2,
            null,
            null),
        new TreeNode(22,
            null,
            new TreeNode(63,
                null,
                new TreeNode(84))));
    final TreeNode result = new Solution().searchBST(tree, 63);
    System.out.println(result);
  }
}
