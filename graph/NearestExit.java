package graph;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/nearest-exit-from-entrance-in-maze

public class NearestExit {
  static class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
      int m = maze.length, n = maze[0].length;
      boolean[][] visited = new boolean[m][n];
      Queue<int[]> queue = new LinkedList<>();
      queue.add(entrance);
      visited[entrance[0]][entrance[1]] = true;
      int steps = 0;
      int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
      while (!queue.isEmpty()) {
        int size = queue.size();
        for (int s = 0; s < size; s++) {
          int[] pos = queue.poll();
          int i = pos[0], j = pos[1];
          // Check if it's an exit (not entrance, on border)
          if ((i != entrance[0] || j != entrance[1]) && (i == 0 || i == m-1 || j == 0 || j == n-1)) {
            return steps;
          }
          for (int[] d : dirs) {
            int ni = i + d[0], nj = j + d[1];
            if (ni >= 0 && ni < m && nj >= 0 && nj < n && maze[ni][nj] == '.' && !visited[ni][nj]) {
              queue.add(new int[]{ni, nj});
              visited[ni][nj] = true;
            }
          }
        }
        steps++;
      }
      return -1;
    }
  }

  public static void main(String[] args) {
    // maze = [["+","+",".","+"],[".",".",".","+"],["+","+","+","."]], entrance = [1,2]

    var maze =
        new char[][] {
          {'+', '+', '.', '+'},
          {'.', '.', '.', '+'},
          {'+', '+', '+', '.'}
        };

    System.out.println(new Solution().nearestExit(maze, new int[] {1, 2}));
  }
}
