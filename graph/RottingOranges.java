package graph;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/rotting-oranges

public class RottingOranges {
  static class Solution {
    public int orangesRotting(int[][] grid) {
      int m = grid.length;
      int n = grid[0].length;
      int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
      Queue<int[]> queue = new LinkedList<>();
      int fresh = 0;

      // Initialize queue with all rotten oranges and count fresh ones
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (grid[i][j] == 2) {
            queue.add(new int[] {i, j});
          } else if (grid[i][j] == 1) {
            fresh++;
          }
        }
      }

      int steps = 0;
      while (!queue.isEmpty() && fresh > 0) {
        int size = queue.size();
        for (int s = 0; s < size; s++) {
          int[] rt = queue.poll();
          int x = rt[0];
          int y = rt[1];
          for (final int[] dir : dirs) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == 1) {
              grid[newX][newY] = 2;
              queue.add(new int[] {newX, newY});
              fresh--;
            }
          }
        }
        steps++;
      }

      return fresh == 0 ? steps : -1;
    }
  }

  public static void main(String[] args) {
    //grid = [[2,1,1],[1,1,0],[0,1,1]]
    System.out.println(
        new Solution().orangesRotting(new int[][] {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
  }
}
