package binarytree;

import binarytree.util.BinaryTreeNode;
import java.util.Objects;

// (problem statement or link here if needed)

public class BinaryTreeSymmetric {

  public static boolean isSymmetric(BinaryTreeNode<Integer> tree){
    return tree == null || checkSymmetric(tree.left, tree.right);
  }

  private static boolean checkSymmetric(
      final BinaryTreeNode<Integer> left,
      final BinaryTreeNode<Integer> right
  ) {
    if(left == null && right == null) {
      return true;
    } else if(left != null && right != null) {
      return Objects.equals(left.data, right.data)
          && checkSymmetric(left.left, right.right)
          && checkSymmetric(left.right, right.left);
    }

    return false;
  }
}
