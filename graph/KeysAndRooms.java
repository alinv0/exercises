package graph;

// https://leetcode.com/problems/keys-and-rooms

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.ArrayDeque;

public class KeysAndRooms {
  static class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
      if (rooms.isEmpty()) {
        return true;
      }

      var visited = new HashSet<Integer>();
      Queue<Integer> keys = new ArrayDeque<>(rooms.get(0));
      keys.add(0);

      while (!keys.isEmpty() && visited.size() < rooms.size()) {
        int key = keys.remove();
        visited.add(key);
        for (int nextKey : rooms.get(key)) {
          if (visited.add(nextKey)) {
            keys.add(nextKey);
          }
        }
      }
      return visited.size() == rooms.size();
    }
  }

  public static void main(String[] args) {
    // Input: rooms = [[1],[2],[3],[]]
    List<List<Integer>> rooms =
        Arrays.asList(List.of(1), List.of(2), List.of(3), List.of());
    System.out.println(new KeysAndRooms.Solution().canVisitAllRooms(rooms));

    // Input: rooms = [[1,3],[3,0,1],[2],[0]]
    rooms =
        Arrays.asList(
            Arrays.asList(1, 3), Arrays.asList(3, 0, 1), List.of(2), List.of(0));
    System.out.println(new KeysAndRooms.Solution().canVisitAllRooms(rooms));
  }
}
