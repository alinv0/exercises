package binarytree;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import binarytree.base.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSum {
  static class Solution {
    public int maxLevelSum(TreeNode root) {
      if (root == null) return 0;

      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);
      int maxSum = Integer.MIN_VALUE;
      int minLevel = 1;
      int level = 1;

      while (!queue.isEmpty()) {
        int levelSize = queue.size();
        int currentLevelSum = 0;

        for (int i = 0; i < levelSize; i++) {
          TreeNode node = queue.poll();
          currentLevelSum += node.val;

          if (node.left != null) queue.offer(node.left);
          if (node.right != null) queue.offer(node.right);
        }

        if (maxSum < currentLevelSum) {
          minLevel = level;
          maxSum = currentLevelSum;
        }

        level++;
      }

      return minLevel;
    }

    private Map<Integer, List<Integer>> levelOrderTraversal(TreeNode root, int level) {
      // This method is not needed for the current implementation
      return Collections.emptyMap();
    }
  }

  public static void main(String[] args){
    Solution s = new Solution();
    System.out.println(s.maxLevelSum(
        new TreeNode(1,
            new TreeNode(7,
                new TreeNode(7), new TreeNode(-8)),
            new TreeNode(0))));
  }
}
