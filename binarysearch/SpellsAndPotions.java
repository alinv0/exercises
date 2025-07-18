package binarysearch;

// https://leetcode.com/problems/successful-pairs-of-spells-and-potions

import java.util.Arrays;

public class SpellsAndPotions {
  static class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
      Arrays.sort(potions);
      int[] pairs = new int[spells.length];

      for (int t = 0; t < spells.length; t++) {
        int spell = spells[t];

        int minPotion = 0;
        int maxPotion = potions.length - 1;
        while (minPotion <= maxPotion) {
          int mid = minPotion + (maxPotion - minPotion) / 2;
          long power = (long) potions[mid] * spell;
          if (power >= success) {
            maxPotion = mid - 1;
          } else {
            minPotion = mid + 1;
          }
        }
        pairs[t] = potions.length - minPotion;
      }

      return pairs;
    }
  }

  public static void main(String[] args) {
    System.out.println(
        Arrays.toString(
            new Solution().successfulPairs(new int[] {5, 1, 3}, new int[] {1, 2, 3, 4, 5}, 7)));
  }
}
