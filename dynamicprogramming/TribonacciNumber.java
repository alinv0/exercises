package dynamicprogramming;

// https://leetcode.com/problems/n-th-tribonacci-number

public class TribonacciNumber {

  static class Solution {
    public int tribonacci(int n) {
      if (n == 0) return 0;
      if (n == 1 || n == 2) return 1;
      int t0 = 0, t1 = 1, t2 = 1;
      for (int i = 3; i <= n; i++) {
        int next = t0 + t1 + t2;
        t0 = t1;
        t1 = t2;
        t2 = next;
      }
      return t2;
    }
  }

  public static void main(String[] args) {
    System.out.println(new Solution().tribonacci(4));
    System.out.println(new Solution().tribonacci(25));
  }
}
