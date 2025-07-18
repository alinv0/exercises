package dynamicprogramming;

// https://leetcode.com/problems/min-cost-climbing-stairs

public class MinCostClimbingStairs {
  static class Solution {
    public int minCostClimbingStairs(int[] cost) {
      int n = cost.length;
      int prev2 = 0, prev1 = 0;
      for (int i = 2; i <= n; i++) {
        int curr = Math.min(prev1 + cost[i-1], prev2 + cost[i-2]);
        prev2 = prev1;
        prev1 = curr;
      }
      return prev1;
    }
  }

  public static void main(String[] args){
    System.out.println(new Solution().minCostClimbingStairs(new int[]{10,15,20}));
    System.out.println(new Solution().minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
  }
}
