package stack;

// https://leetcode.com/problems/asteroid-collision

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
  static class Solution {
    public int[] asteroidCollision(int[] asteroids) {
      if (asteroids.length == 0) {
        return asteroids;
      }

      Stack<Integer> s = new Stack<>();
      for (int asteroid : asteroids) {
        boolean exploded = false;
        while (!s.isEmpty() && asteroid < 0 && s.peek() > 0) {
          if (s.peek() < -asteroid) {
            s.pop();
            continue;
          } else if (s.peek() == -asteroid) {
            s.pop();
          }
          exploded = true;
          break;
        }
        if (!exploded) {
          s.push(asteroid);
        }
      }

      int[] result = new int[s.size()];
      for (int i = s.size() - 1; i >= 0; i--) {
        result[i] = s.pop();
      }

      return result;
    }
  }
  public static void main(String[] args){

//      int[] result = new Solution().asteroidCollision(new int[] {-2, -2, 1, -1});
//      System.out.println(Arrays.toString(result));

//    int[] result = new Solution().asteroidCollision(new int[] {-2, -1, 1, 2});
//    System.out.println(Arrays.toString(result));

//    int[] result = new Solution().asteroidCollision(new int[] {8, -8});
//    System.out.println(Arrays.toString(result));

    int[] result = new Solution().asteroidCollision(new int[] {10, 2, -5});
    System.out.println(Arrays.toString(result));

    //[-2,-1,1,2]
//    System.out.println(
//        new Solution().asteroidCollision(new int[] {5, 10, -5})
//    );

    //[-2,-1,1,2]
//    System.out.println(
//        new Solution().asteroidCollision(new int[] {-2, -1, 1, 2})
//    );
  }
}
