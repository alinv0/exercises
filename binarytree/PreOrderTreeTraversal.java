package binarytree;

// (problem statement or link here if needed)

import java.util.ArrayList;
import java.util.List;
import binarytree.base.TreeNode;

public class PreOrderTreeTraversal {
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

    System.out.println(preOrderTraversal(root));
  }

  public static List<Integer> preOrderTraversal(TreeNode root) {
    preOrderTraverse(root);
    return nodes;
  }

  public static List<Integer> nodes = new ArrayList<>();

  static void preOrderTraverse(TreeNode root) {
    if (root == null) {
      return;
    }

    nodes.add(root.val);
    preOrderTraverse(root.left);
    preOrderTraverse(root.right);
  }
}
