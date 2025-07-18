package binarytree;

import binarytree.util.BinaryTreeNode;
import binarytree.util.TreeBuilder;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
  static class Solution {
    public void printLevels(BinaryTreeNode root) {
      Queue<BinaryTreeNode> queue = new LinkedList<>();
      queue.add(root);
      int level = 1;

      while (!queue.isEmpty()) {
        int levelSize = queue.size();
        System.out.print(level + ": ");
        for (int i = 0; i < levelSize; i++) {
          BinaryTreeNode node = queue.poll();
          System.out.print(node.data + " ");
          if (node.left != null) {
            queue.offer(node.left);
          }
          if (node.right != null) {
            queue.offer(node.right);
          }
        }
        System.out.println();
        level ++;
      }
    }
  }

  public static void main(String[] args) {
    new Solution().printLevels(TreeBuilder.buildBinaryTreeWithStringValues());
  }
}
