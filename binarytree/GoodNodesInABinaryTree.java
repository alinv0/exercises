package binarytree;

// https://leetcode.com/problems/count-good-nodes-in-binary-tree

import binarytree.base.TreeNode;

public class GoodNodesInABinaryTree {
  static class Solution {
    public int goodNodes(TreeNode root) {
      return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int max) {
      if (node == null) {
        return 0;
      }

      int good = 0;

      if (max <= node.val) {
        good = 1;
        max = node.val;
      }

      return good + dfs(node.left, max) + dfs(node.right, max);
    }
  }

  public static void main(String[] args){
    System.out.println(new Solution().goodNodes(
        new TreeNode(1,
            new TreeNode(2,
                new TreeNode(4),
                new TreeNode(5,
                    new TreeNode(6),
                    new TreeNode(7))),
            new TreeNode(3,
                null,
                new TreeNode(8,
                    new TreeNode(9), null)))));
  }
}
