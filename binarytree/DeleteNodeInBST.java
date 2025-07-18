package binarytree;

import binarytree.base.TreeNode;

// https://leetcode.com/problems/delete-node-in-a-bst/?envType=study-plan-v2&envId=leetcode-75

public class DeleteNodeInBST {
  static class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
      if (root == null) return null;
      if (key < root.val) {
        root.left = deleteNode(root.left, key);
      } else if (key > root.val) {
        root.right = deleteNode(root.right, key);
      } else {
        // Node to delete found
        if (root.left == null) {
          return root.right;
        } else if (root.right == null) {
          return root.left;
        } else {
          // Node with two children: get the inorder successor (smallest in the right subtree)
          TreeNode minNode = findMin(root.right);
          root.val = minNode.val;
          root.right = deleteNode(root.right, minNode.val);
        }
      }
      return root;
    }

    private TreeNode findMin(TreeNode node) {
      while (node.left != null) {
        node = node.left;
      }
      return node;
    }
  }

  public static void main(String[] args){
    System.out.println(new Solution().deleteNode(
        new TreeNode(5,
            new TreeNode(3,
                new TreeNode(2),
                new TreeNode(4)),
            new TreeNode(6,
                null,
                new TreeNode(7))), 3
    ));
  }
}
