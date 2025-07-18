package dynamicprogramming;

// https://leetcode.com/problems/longest-common-subsequence

public class LongestCommonSubsequence {
  static class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
      int m = text1.length();
      int n = text2.length();
      int[][] dp = new int[m + 1][n + 1];

      for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
          if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
            //found one more char in common, new length is previous length + 1
            dp[i][j] = dp[i - 1][j - 1] + 1;
          } else {
            //take the max of the two previous lengths
            dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
          }
        }
      }
      return dp[m][n];
    }
  }

  public static void main(String[] args) {
    System.out.println(new Solution().longestCommonSubsequence("abcde", "ace"));
  }
}
