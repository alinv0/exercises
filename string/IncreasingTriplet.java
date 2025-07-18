package string;

// https://leetcode.com/problems/increasing-triplet-subsequence

public class IncreasingTriplet {
  static class Solution {
    public boolean increasingTriplet(int[] nums) {
      if (nums.length < 3) {
        return false;
      }

      int first = Integer.MAX_VALUE;
      int second = Integer.MAX_VALUE;

      for (int num : nums) {
        if (num <= first) {
          first = num;
        } else if (num <= second) {
          second = num;
        } else {
          return true;
        }
      }

      return false;
    }
  }

  public static void main(String[] args) {
    //    System.out.println(new Solution().increasingTriplet(new int[] {1,2,3,4,5}));
    //    System.out.println(new Solution().increasingTriplet(new int[] {5,4,3,2,1}));
//    System.out.println(new Solution().increasingTriplet(new int[] {2, 1, 5, 0, 4, 6}));

    // [20,100,10,12,5,13]
    System.out.println(new Solution().increasingTriplet(new int[] {20,100,10,12,5,13}));
  }
}
