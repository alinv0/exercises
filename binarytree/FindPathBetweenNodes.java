package binarytree;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int val) {
    this.val = val;
    this.left = null;
    this.right = null;
  }
}

public class FindPathBetweenNodes {
  public static String findPath(TreeNode root, int num1, int num2) {
    List<String> path1 = new ArrayList<>();
    List<String> path2 = new ArrayList<>();

    if (!findPathHelper(root, num1, path1) || !findPathHelper(root, num2, path2)) {
      return "Path not found";
    }

    int commonAncestor = -1;

    for (int i = 0; i < Math.min(path1.size(), path2.size()); i++) {
      if (path1.get(i).equals(path2.get(i))) {
        commonAncestor = i;
      } else {
        break;
      }
    }

    StringBuilder pathBuilder = new StringBuilder();

    for (int i = path1.size() - 1; i > commonAncestor; i--) {
      pathBuilder.append("up ");
    }

    for (int i = path2.size() - 1; i > commonAncestor; i--) {
      if (path2.get(i).equals("left")) {
        pathBuilder.append("right ");
      } else {
        pathBuilder.append("left ");
      }
    }

    return pathBuilder.toString().trim();
  }

  private static boolean findPathHelper(TreeNode node, int target, List<String> path) {
    if (node == null) {
      return false;
    }

    path.add(node.val + "");

    if (node.val == target) {
      return true;
    }

    if (findPathHelper(node.left, target, path) || findPathHelper(node.right, target, path)) {
      return true;
    }

    path.remove(path.size() - 1);

    return false;
  }

  public static void main(String[] args) {
    // Example usage:
    // Construct the binary tree:
    //       1
    //      / \
    //     2   3
    //    / \
    //   4   5
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);

    int num1 = 4;
    int num2 = 3;

    String path = findPath(root, num1, num2);
    System.out.println(path); // Output: "up up right"
  }
} 