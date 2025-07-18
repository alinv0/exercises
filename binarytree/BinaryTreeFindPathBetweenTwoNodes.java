package binarytree;

import binarytree.util.BinaryTreeNode;
import binarytree.util.TreeBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Given two nodes of the tree, find the path from one to the other
 */
public class BinaryTreeFindPathBetweenTwoNodes {

  public static String lca;
  public static List pathToSource = new ArrayList<String>();
  public static List pathToDestination = new ArrayList<String>();

  public static void main(String[] args){
    var tree = TreeBuilder.buildBinaryTreeWithStringValues();
    System.out.println(findPath(tree, "M", "O"));
  }

  private static String findPath(
      final BinaryTreeNode<String> tree,
      final String source,
      final String destination) {
    pathToSource = new ArrayList<String>();
    pathToDestination = new ArrayList<String>();

    findPathToNode(tree, source, pathToSource);
    findPathToNode(tree, destination, pathToDestination);

    for(int i=pathToSource.size()-1; i>=0; i--) {
      if(pathToDestination.contains(pathToSource.get(i))) {
        lca = pathToSource.get(i).toString();
        break;
      }
    }

    System.out.println("source: " + pathToSource);
    System.out.println("dest: " + pathToDestination);
    System.out.println("LCA: " + lca);
    System.out.println("Path: " + getPath());

    return "";
  }

  private static String getPath() {
    if(Objects.isNull(lca) || lca.isEmpty()) {
      return "";
    }

    StringBuilder p = new StringBuilder();
    for(int i=pathToSource.size()-1; i>=0; i--) {
      p.append(pathToSource.get(i));
      if(pathToSource.get(i) == lca) {
        break;
      }
    }
    StringBuilder q = new StringBuilder();
    for(int i=pathToDestination.size()-1; i>=0; i--) {
      if(pathToDestination.get(i) == lca) {
        break;
      }
      q.append(pathToDestination.get(i));
    }

    return p + q.reverse().toString();
  }

  private static boolean findPathToNode(
      BinaryTreeNode<String> from,
      String node, List path) {
    if(from == null) {
      return false;
    }

    path.add(from.data);

    if(from.data.equals(node)) {
      return true;
    }

    if (findPathToNode(from.left, node, path) ||
    findPathToNode(from.right, node, path)) {
      return true;
    }

    path.remove(path.get(path.size()-1));
    return false;
  }
}
