package dynamicprogramming;

import java.util.*;

public class Problem1 {
  static class Solution {
    public static int optimalJourneyTotal(List<Integer> cities) {
      int n = cities.size();
      if (n == 0) return 0;
      if (n == 1) return cities.get(0);

      // Precompute all primes up to n using Sieve of Eratosthenes
      boolean[] isPrime = sieveOfEratosthenes(n);

      // dp[i] represents the maximum money we can have when reaching city i
      int[] dp = new int[n];
      Arrays.fill(dp, Integer.MIN_VALUE);
      dp[0] = cities.get(0);

      // For each city, try to reach it from all possible previous cities
      for (int i = 1; i < n; i++) {
        // Check adjacent city (distance 1)
        if (dp[i - 1] != Integer.MIN_VALUE) {
          dp[i] = Math.max(dp[i], dp[i - 1] + cities.get(i));
        }
        
        // Check prime distances ending in 3 (3, 13, 23, 43, 53, 73, 83, ...)
        for (int distance = 3; distance <= i && distance < isPrime.length; distance++) {
          if (isPrime[distance] && distance % 10 == 3) {
            int prevCity = i - distance;
            if (dp[prevCity] != Integer.MIN_VALUE) {
              dp[i] = Math.max(dp[i], dp[prevCity] + cities.get(i));
            }
          }
        }
      }

      return dp[n - 1] == Integer.MIN_VALUE ? 0 : dp[n - 1];
    }

    private static boolean[] sieveOfEratosthenes(int max) {
      boolean[] isPrime = new boolean[max + 1];
      Arrays.fill(isPrime, true);
      isPrime[0] = isPrime[1] = false;

      for (int i = 2; i * i <= max; i++) {
        if (isPrime[i]) {
          for (int j = i * i; j <= max; j += i) {
            isPrime[j] = false;
          }
        }
      }
      return isPrime;
    }
  }

  public static void main(String[] args) {
    // Sample test case from the problem
    List<Integer> sampleCities = Arrays.asList(0, -20, 80, -40, -10);
    System.out.println("Sample test result: " + Solution.optimalJourneyTotal(sampleCities));
    
    // Original test cases
//    List<Integer> cities = Arrays.asList(0, 100, 200, -500, -100, -150, -50);
//    System.out.println("Optimal journey total: " + Solution.optimalJourneyTotal(cities));

    // Test with the example from the problem
//    List<Integer> testCities = Arrays.asList(0, 100, 200, -500, -100, -150, -50);
//    System.out.println("Test result: " + Solution.optimalJourneyTotal(testCities));
  }
} 