package binarytree;

import binarytree.base.TreeNode;

//https://leetcode.com/problems/path-sum-iii

public class PathSumIII {
  static class MySolution {
    int pathsCount = 0;

    public int pathSum(TreeNode root, int targetSum) {
      check(root, targetSum);
      return pathsCount;
    }

    public void check(TreeNode root, int targetSum) {
      if(root == null) {
        return;
      }

      dfs(root, 0, targetSum);
      check(root.left, targetSum);
      check(root.right, targetSum);
    }

    public void dfs(TreeNode node, long currentSum, long targetSum) {
      if (node == null) {
        return;
      }

      currentSum += node.val;

      if (currentSum == targetSum) {
        pathsCount++;
      }

      dfs(node.left, currentSum, targetSum);
      dfs(node.right, currentSum, targetSum);
    }
  }

  static class EfficientSolution {
    public int pathSum(TreeNode root, int targetSum) {
      java.util.Map<Long, Integer> prefixSums = new java.util.HashMap<>();
      prefixSums.put(0L, 1); // Base case: one way to have sum = 0
      return dfs(root, 0L, targetSum, prefixSums);
    }

    private int dfs(TreeNode node, long currentSum, int targetSum, java.util.Map<Long, Integer> prefixSums) {
      if (node == null) return 0;
      currentSum += node.val;
      int count = prefixSums.getOrDefault(currentSum - targetSum, 0);
      prefixSums.put(currentSum, prefixSums.getOrDefault(currentSum, 0) + 1);
      count += dfs(node.left, currentSum, targetSum, prefixSums);
      count += dfs(node.right, currentSum, targetSum, prefixSums);
      prefixSums.put(currentSum, prefixSums.get(currentSum) - 1); // Backtrack

      if(count > 0) {
        System.out.println("Node: " + node.val);
      }

      return count;
    }
  }

  public static void main(String[] args) {
    System.out.println(
        new EfficientSolution()
            .pathSum(
                new TreeNode(
                    10,
                    new TreeNode(
                        5,
                        new TreeNode(3, new TreeNode(3), new TreeNode(-2)),
                        new TreeNode(2, null, new TreeNode(1))),
                    new TreeNode(-3, null, new TreeNode(11))),
                8));

    System.out.println(new MySolution().pathSum(
        new TreeNode(-2,
            null,
            new TreeNode(-3)),
        -5)
    );

    System.out.println(new MySolution().pathSum(
        new TreeNode(1000000000,
            new TreeNode(1000000000,
                new TreeNode(294967296,
                    new TreeNode(1000000000,
                        new TreeNode(1000000000,
                            new TreeNode(1000000000, null, null),
                            null),
                        null),
                    null),
                null),
            null),
        0)
    );
  }
}