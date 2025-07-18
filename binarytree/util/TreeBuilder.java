package binarytree.util;


public class TreeBuilder {

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
 *
 */
  public static BinaryTreeNode<Integer> buildBinaryTreeWithBinaryValues() {
    var root = new BinaryTreeNode<>(1);

    var node0 = new BinaryTreeNode<>(0);
    var node1 = new BinaryTreeNode<>(1);
    root.left = node0;
    root.right = node1;

    var node2 = new BinaryTreeNode<>(0);
    var node3 = new BinaryTreeNode<>(1);
    var node4 = new BinaryTreeNode<>(0);
    var node5 = new BinaryTreeNode<>(0);
    node0.left = node2;
    node0.right = node3;
    node1.left = node4;
    node1.right = node5;

    var node6 = new BinaryTreeNode<>(0);
    var node7 = new BinaryTreeNode<>(1);
    var node8 = new BinaryTreeNode<>(1);
    var node9 = new BinaryTreeNode<>(0);
    var node10 = new BinaryTreeNode<>(0);
    node2.left = node6;
    node2.right = node7;
    node3.right = node8;
    node4.right = node9;
    node5.right = node10;

    var node11 = new BinaryTreeNode<>(0);
    var node12 = new BinaryTreeNode<>(1);
    var node13 = new BinaryTreeNode<>(0);
    node8.left = node11;
    node9.left = node12;
    node9.right = node13;

    var node14 = new BinaryTreeNode<>(1);
    node12.right = node14;

    return root;
  }

  /**
   *                       root(A)
   *                     /        \
   *                  0(B)        1(C)
   *                 /   \        /   \
   *              2(D)   3(E)  4(F)  5(G)
   *             /  \       \    \       \
   *           6(H) 7(I)   8(J)  9(K)   10(L)
   *                        /   /   \
   *                    11(M) 12(N)  13(O)
   *                            \
   *                             14(P)
   *
   *
   */
  public static BinaryTreeNode<String> buildBinaryTreeWithStringValues() {
    var root = new BinaryTreeNode<>("A");

    var node0 = new BinaryTreeNode<>("B");
    var node1 = new BinaryTreeNode<>("C");
    root.left = node0;
    root.right = node1;

    var node2 = new BinaryTreeNode<>("D");
    var node3 = new BinaryTreeNode<>("E");
    var node4 = new BinaryTreeNode<>("F");
    var node5 = new BinaryTreeNode<>("G");
    node0.left = node2;
    node0.right = node3;
    node1.left = node4;
    node1.right = node5;

    var node6 = new BinaryTreeNode<>("H");
    var node7 = new BinaryTreeNode<>("I");
    var node8 = new BinaryTreeNode<>("J");
    var node9 = new BinaryTreeNode<>("K");
    var node10 = new BinaryTreeNode<>("L");
    node2.left = node6;
    node2.right = node7;
    node3.right = node8;
    node4.right = node9;
    node5.right = node10;

    var node11 = new BinaryTreeNode<>("M");
    var node12 = new BinaryTreeNode<>("N");
    var node13 = new BinaryTreeNode<>("O");
    node8.left = node11;
    node9.left = node12;
    node9.right = node13;

    var node14 = new BinaryTreeNode<>("P");
    node12.right = node14;

    return root;
  }
}
