package binarysearch;

// https://leetcode.com/problems/koko-eating-bananas

import java.util.Arrays;

public class KokoEatingBananas {
  static int hoursSpentPerPile(int pile, int eatingSpeed) {
    return (int) Math.ceil((double) pile / eatingSpeed);
  }

  static class Solution {
    public int minEatingSpeed(int[] piles, int h) {
      int low = 1;
      int high = Arrays.stream(piles).max().getAsInt();
      while (low <= high) {
        int mid = low + (high - low) / 2;
        long totalHours = Arrays.stream(piles).mapToLong(p -> hoursSpentPerPile(p, mid)).sum();
        if (totalHours <= h) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      }
      return low;
    }
  }

  public static void main(String[] args) {
    System.out.println(new Solution().minEatingSpeed(new int[] {3, 6, 7, 11}, 8));
    System.out.println(new Solution().minEatingSpeed(new int[] {30, 11, 23, 4, 20}, 5));
    System.out.println(new Solution().minEatingSpeed(new int[] {30, 11, 23, 4, 20}, 6));
    System.out.println(new Solution().minEatingSpeed(new int[] {805306368,805306368,805306368}, 1000000000));
  }
}
