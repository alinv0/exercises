package graph;

// https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero

import java.util.*;

public class ReorderRoutes {
  static class Solution {
    boolean[] visited;
    int changed;
    Map<Integer, List<int[]>> adj;

    public int minReorder(int n, int[][] connections) {
      visited = new boolean[n];
      changed = 0;
      adj = new HashMap<>();
      for (int i = 0; i < n; i++) adj.put(i, new ArrayList<>());
      for (int[] c : connections) {
        adj.get(c[0]).add(new int[]{c[1], 1}); // original direction
        adj.get(c[1]).add(new int[]{c[0], 0}); // reverse direction
      }
      dfs(0);
      return changed;
    }

    private void dfs(int node) {
      visited[node] = true;
      for (int[] neighbor : adj.get(node)) {
        int next = neighbor[0], needsChange = neighbor[1];
        if (!visited[next]) {
          changed += needsChange;
          dfs(next);
        }
      }
    }
  }

  public static void main(String[] args) {
//    System.out.println(
//        new Solution().minReorder(6, new int[][] {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}}));


    //[[4,5],[0,1],[1,3],[2,3],[4,0]]
    System.out.println(
        new Solution().minReorder(6, new int[][] {{4, 5}, {0, 1}, {1, 3}, {2, 3}, {4, 0}}));
  }
}
