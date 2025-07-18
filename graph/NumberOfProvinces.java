package graph;

// https://leetcode.com/problems/number-of-provinces


import java.util.HashMap;
import java.util.Map;

public class NumberOfProvinces {
  static class Solution {
    public int findCircleNum(int[][] isConnected) {
      boolean[] visited = new boolean[isConnected.length];
      Map<Integer, boolean[]> provinces = new HashMap<>();
      for (int i = 0; i < isConnected.length; i++) {
        if(!visited[i]) {
          provinces.put(i, dfs(isConnected, i, visited));
        }
      }

      return provinces.size();
    }

    private boolean[] dfs(int[][] isConnected, int city, boolean[] visited) {
      visited[city] = true;
      for(int i = 0; i < isConnected[city].length; i++) {
        if(isConnected[city][i] == 1 && !visited[i]) {
          dfs(isConnected, i, visited);
        }
      }

      return visited;
    }
  }

  public static void main(String[] args){
    System.out.println(new Solution().findCircleNum(new int[][] {
        {1, 1, 0},
        {1, 1, 0},
        {0, 0, 1}
    }));
  }
}
