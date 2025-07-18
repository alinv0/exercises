package binarytree;

import binarytree.base.TreeNode;

// https://leetcode.com/problems/maximum-depth-of-binary-tree

public class MaxDepthOfBinaryTree {
  static class Solution {
    public int maxDepth(TreeNode root) {
      return dfs(root, 1);
    }

    private int dfs(TreeNode node, int level) {
      if(node == null) {
        return level-1;
      }
      return Math.max(dfs(node.left, level+1), dfs(node.right, level+1));
    }
  }

  public static void main(String[] args){
    System.out.println(new Solution().maxDepth(
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
