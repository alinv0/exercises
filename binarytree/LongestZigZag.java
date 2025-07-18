package binarytree;

// https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree

import binarytree.base.TreeNode;

public class LongestZigZag {

  static class Solution {
    int maxPath = 0;

    public int longestZigZag(TreeNode root) {
      if (root == null) return 0;
      // Start DFS from root in both directions
      dfs(root.left, true, 1);  // true: left
      dfs(root.right, false, 1); // false: right
      return maxPath;
    }

    // direction: true for left, false for right
    private void dfs(TreeNode node, boolean isLeft, int length) {
      if (node == null) return;
      maxPath = Math.max(maxPath, length);
      if (isLeft) {
        dfs(node.left, true, 1); // change direction, reset length
        dfs(node.right, false, length + 1); // continue zigzag
      } else {
        dfs(node.left, true, length + 1); // continue zigzag
        dfs(node.right, false, 1); // change direction, reset length
      }
    }
  }

  public static void main(String[] args){
    System.out.println(new Solution().longestZigZag(
        new TreeNode(1,
            null,
            new TreeNode(2,
                new TreeNode(3),
                new TreeNode(4,
                    new TreeNode(5,
                        null,
                        new TreeNode(6,
                            null,
                            new TreeNode(7))),
                    new TreeNode(8))))
    ));
  }
}
