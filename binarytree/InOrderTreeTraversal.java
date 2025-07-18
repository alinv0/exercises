package binarytree;

// https://leetcode.com/problems/binary-tree-inorder-traversal/

import java.util.ArrayList;
import java.util.List;
import binarytree.base.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */

public class InOrderTreeTraversal {
  public static void main(String[] args){
    TreeNode root =
        new TreeNode(1,
          new TreeNode(2,
            new TreeNode(4),
            new TreeNode(5,
              new TreeNode(6),
              new TreeNode(7))),
        new TreeNode(3,
            null,
            new TreeNode(8,
                new TreeNode(9), null)));

    System.out.println(inorderTraversal(root));
  }

  public static List<Integer> inorderTraversal(TreeNode root) {
    inOrderTraverse(root);
    return nodes;
  }

  public static List<Integer> nodes = new ArrayList<>();

  static void inOrderTraverse(TreeNode root) {
    if (root == null) {
      return;
    }

    inOrderTraverse(root.left);
    nodes.add(root.val);
    inOrderTraverse(root.right);
  }
}
