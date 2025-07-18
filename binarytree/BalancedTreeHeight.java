package binarytree;

import binarytree.util.BinaryTreeNode;


public class BalancedTreeHeight {
  public boolean balanced;
  public int height;

  public BalancedTreeHeight(boolean balanced, int height) {
    this.balanced = balanced;
    this.height = height;
  }

  public static boolean isBalanced(BinaryTreeNode<Integer> tree) {
    return checkBalanced(tree).balanced;
  }

  private static BalancedTreeHeight checkBalanced(BinaryTreeNode<Integer> tree) {
    if(tree == null) {
      return new BalancedTreeHeight(true, -1);
    }

    if(tree.left == null && tree.right == null) {
      return new BalancedTreeHeight(true, 1);
    }

    BalancedTreeHeight leftResult = checkBalanced(tree.left);
    if(!leftResult.balanced) {
      return leftResult;
    }

    BalancedTreeHeight rightResult = checkBalanced(tree.right);
    if(!rightResult.balanced) {
      return rightResult;
    }

    boolean isBalanced = Math.abs(leftResult.height - rightResult.height) <= 1;
    int height = Math.max(leftResult.height, rightResult.height) + 1;
    return new BalancedTreeHeight(isBalanced, height);
  }
}
