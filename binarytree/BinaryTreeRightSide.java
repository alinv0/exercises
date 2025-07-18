package binarytree;

// https://leetcode.com/problems/binary-tree-right-side-view/description/?envType=study-plan-v2&envId=leetcode-75

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import binarytree.base.TreeNode;

public class BinaryTreeRightSide {
  static class Solution {
    public List<Integer> rightSideView(TreeNode root) {
      if(root == null) {
        return Collections.emptyList();
      }
      List<Integer> result = new LinkedList<>();

      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);
      while(!queue.isEmpty()) {
        int levelSize = queue.size();
        for(int i = 0; i < levelSize; i++) {
          TreeNode node = queue.poll();
          if(i == levelSize - 1) {
            result.add(node.val);
          }

          if(node.left != null) {
            queue.offer(node.left);
          }

          if(node.right != null) {
            queue.offer(node.right);
          }
        }
      }
      return result;
    }
  }

  public static void main(String[] args){

  }
}
