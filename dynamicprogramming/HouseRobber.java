package dynamicprogramming;

// https://leetcode.com/problems/house-robber

public class HouseRobber {
  static class Solution {
    public int rob(int[] nums) {
      int n = nums.length;
      int prev2 = 0, prev1 = 0;
      if(nums.length == 0) return 0;
      if(nums.length == 1) return nums[0];
      for(int i=1; i<=n; i++) {
        int curr = Math.max(prev1, prev2 + nums[i-1]);
        prev2 = prev1;
        prev1 = curr;
      }
      return prev1;
    }
  }

  public static void main(String[] args){
    System.out.println(new Solution().rob(new int[]{1,2,3,1}));
    System.out.println(new Solution().rob(new int[]{2,7,9,3,1}));
  }
}
