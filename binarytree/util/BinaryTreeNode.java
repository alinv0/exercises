package binarytree.util;

public class BinaryTreeNode<T>{
  public T data;
  public BinaryTreeNode<T> left;
  public BinaryTreeNode<T> right;

  public BinaryTreeNode(T value) {
    this.data = value;
  }

  public BinaryTreeNode() {

  }
}