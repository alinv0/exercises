package binarytree;

import binarytree.util.BinaryTreeNode;
import binarytree.util.TreeBuilder;

/**
 * Design an algorithm to compute the sum of the binary numbers represented by the
 * root-to-leaf paths.
 */
public class BinaryTreeSumOfAllPaths {

  public static int sumRootToLeaf(BinaryTreeNode<Integer> tree) {
    return sumRootToLeafHelper(tree, 0);
  }

  private static int sumRootToLeafHelper(
      final BinaryTreeNode<Integer> tree,
      int partialPathSum) {
    if(tree == null) {
      return 0;
    }

    partialPathSum = 2 * partialPathSum + tree.data;

    if(tree.left == null && tree.right == null) {
      return partialPathSum;
    }

    return sumRootToLeafHelper(tree.left, partialPathSum) +
        sumRootToLeafHelper(tree.right, partialPathSum);
  }

  /**
   *                       (root)1
   *                     /        \
   *                  0(0)        1(1)
   *                 /   \        /   \
   *              2(0)   3(1)  4(0)  5(0)
   *             /  \       \    \       \
   *           6(0) 7(1)   8(1)  9(0)   10(0)
   *                        /   /   \
   *                    11(0) 12(1)  13(0)
   *                            \
   *                             14(1)
   *
   * 1 0 1 1 0 = 2 + 4 + 16 = 22
   * ---------------------------
   * (2 * 0 + 1) +                                            -> 1
   * (2 * (2 * 0 + 1) + 0) +                                  -> 2 * 1 + 0 = 2
   * (2 * (2 * (2 * 0 + 1) + 0) + 1) +                        -> 2 * 2 + 1 = 5
   * (2 * (2 * (2 * (2 * 0 + 1) + 0) + 1) + 1) +              -> 2 * 5 + 1 = 11
   * (2 * (2 * (2 * (2 * (2 * 0 + 1) + 0) + 1) + 1) + 0)      -> 2 * 11 + 0 = 22
   */

  public static void main(String[] args) {
    var tree = TreeBuilder.buildBinaryTreeWithBinaryValues();
    System.out.println(sumRootToLeaf(tree));
  }
}
