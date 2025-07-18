package binarytree;

//https://leetcode.com/problems/leaf-similar-trees

import binarytree.base.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {
  static class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
      final List<Integer> root1List = new ArrayList<>();
      final List<Integer> root2List = new ArrayList<>();

      dfs(root1, root1List);
      dfs(root2, root2List);

      return root1List.equals(root2List);
    }

    private void dfs(TreeNode node, List<Integer> leaves) {
      if(node == null) {
        return;
      }

      if(node.left == null && node.right == null) {
        leaves.add(node.val);
      }

      if(node.left != null) {
        dfs(node.left, leaves);
      }

      if(node.right != null) {
        dfs(node.right, leaves);
      }
    }
  }

  public static void main(String[] args){
    System.out.println(new Solution().leafSimilar(
        new TreeNode(1,
            new TreeNode(2,
                new TreeNode(4),
                new TreeNode(5,
                    new TreeNode(6),
                    new TreeNode(7))),
            new TreeNode(3,
                null,
                new TreeNode(8,
                    new TreeNode(9), null))),
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
