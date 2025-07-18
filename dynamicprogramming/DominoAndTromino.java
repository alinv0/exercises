package dynamicprogramming;

// https://leetcode.com/problems/domino-and-tromino-tiling

public class DominoAndTromino {
  static class Solution {
    public int numTilings(int n) {
      int MOD = 1_000_000_007;
      if (n == 0) return 1;
      if (n == 1) return 1;
      if (n == 2) return 2;
      int[] dp = new int[n + 1];
      dp[0] = 1;
      dp[1] = 1;
      dp[2] = 2;
      for (int i = 3; i <= n; i++) {
        dp[i] = (int)(((2L * dp[i - 1]) % MOD + dp[i - 3]) % MOD);
      }
      return dp[n];
    }
  }

  public static void main(String[] args) {
    System.out.println(new Solution().numTilings(4));
  }
}
