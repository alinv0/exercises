package binarytree;

import java.util.ArrayList;
import java.util.List;
import binarytree.base.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-paths/description/
 *
 * <p>Given the root of a binary tree, return all root-to-leaf paths in any order. A leaf is a node
 * with no children.
 *
 * <p>Example 1: Input: root = [1,2,3,null,5] Output: ["1->2->5","1->3"]
 *
 * <p>Example 2: Input: root = [1] Output: ["1"]
 *
 * <p>Constraints: The number of nodes in the tree is in the range [1, 100]. -100 <= Node.val <= 100
 */
public class BinaryTreePaths {
  public static void main(String[] args) {
    var solution = new Solution();

    final var tree = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3));

    solution.binaryTreePaths(tree);
  }
}

class Solution {
  public List<String> binaryTreePaths(TreeNode root) {
    List<String> paths = new ArrayList<>();
    if (root == null) return paths;
    StringBuilder path = new StringBuilder();
    backtrack(root, path, paths);
    return paths;
  }

  private void backtrack(TreeNode node, StringBuilder path, List<String> paths) {
    int len = path.length();
    if (len != 0) path.append("->");
    path.append(node.val);

    if (isLeaf(node)) {
      paths.add(path.toString());
    } else {
      if (node.left != null) backtrack(node.left, path, paths);
      if (node.right != null) backtrack(node.right, path, paths);
    }
    path.setLength(len); // backtrack
  }

  private boolean isLeaf(TreeNode root) {
    return root.left == null && root.right == null;
  }
} 