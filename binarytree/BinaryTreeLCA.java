package binarytree;

import binarytree.util.BinaryTreeNode;

public class BinaryTreeLCA {
  private static class Status {
    public int numTargetNodes;
    public BinaryTreeNode<Integer> ancestor;

    public Status(int numTargetNodes, BinaryTreeNode<Integer> node) {
      this.numTargetNodes = numTargetNodes;
      this.ancestor = node;
    }
  }

  public static BinaryTreeNode<Integer> LCA(
      BinaryTreeNode<Integer> tree,
      BinaryTreeNode<Integer> node0,
      BinaryTreeNode<Integer> node1) {
    return LCAHelper(tree, node0, node1).ancestor;
  }

  private static Status LCAHelper(
      final BinaryTreeNode<Integer> tree,
      final BinaryTreeNode<Integer> node0,
      final BinaryTreeNode<Integer> node1) {
    if(tree == null) {
      return new Status(0, null);
    }

    Status leftResult = LCAHelper(tree.left, node0, node1);
    if(leftResult.numTargetNodes == 2) {
      return leftResult;
    }

    Status rightResult = LCAHelper(tree.right, node0, node1);
    if(rightResult.numTargetNodes == 2) {
      return rightResult;
    }

    int numTargetNodes = leftResult.numTargetNodes + rightResult.numTargetNodes
        + (tree == node0 ? 1 : 0) + (tree == node1 ? 1 : 0);

    return new Status(numTargetNodes, numTargetNodes == 2 ? tree : null);
  }

  public static void main(String[] args){
    /**
     *         0
     *       /   \
     *     1      2
     *   /  \   /  \
     *  3    4 5    6
     *
     */


    BinaryTreeNode<Integer> root = new BinaryTreeNode<>(0);
    var a = new BinaryTreeNode<>(1);
    root.left = a;
    var b = new BinaryTreeNode<>(2);
    root.right = b;
    var c = new BinaryTreeNode<>(3);
    root.left.left = c;
    var d = new BinaryTreeNode<>(4);
    root.left.right = d;
    var e = new BinaryTreeNode<>(5);
    root.right.left = e;
    var f = new BinaryTreeNode<>(6);
    root.right.right = f;

    System.out.println(LCA(root, f, e).data);
    System.out.println(LCA(root, d, f).data);
  }
}
