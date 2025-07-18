package dynamicprogramming;

import java.util.Arrays;

public class EqualPartition {

  public static void main(String[] args) {
    int[] arr = {1, 5, 11, 5};
    System.out.println("Can partition equally (recursive): " + (equalPartition(4, arr) == 1));
    System.out.println("Can partition equally (DP): " + canPartition(arr));
    
    int[] arr2 = {1, 2, 3, 5};
    System.out.println("\nCan partition equally (recursive): " + (equalPartition(4, arr2) == 1));
    System.out.println("Can partition equally (DP): " + canPartition(arr2));
  }

  static boolean isSubsetSum(int[] arr, int n, int sum) {
    if(sum == 0) {
      return true;
    }

    if(n == 0) {
      return false;
    }

    if (arr[n-1] > sum) {
      return isSubsetSum(arr, n-1, sum);
    }

    return isSubsetSum(arr, n-1, sum)
        || isSubsetSum(arr, n-1, sum-arr[n-1]);
  }

  static int equalPartition(int N, int[] arr) {
    int totalSum = Arrays.stream(arr).sum();

    if(totalSum % 2 != 0) {
      return 0;
    }

    return isSubsetSum(arr, N, totalSum / 2) ? 1 : 0;
  }

  static boolean canPartition(int[] arr) {
    int sum = Arrays.stream(arr).sum();

    if(sum%2 != 0) {
      return false;
    }

    int partitionSum = sum / 2;

    int n = arr.length;

    boolean[][] dp = new boolean[n+1][partitionSum+1];

    for(int i = 0; i <= n; i++) {
      dp[i][0] = true;
    }

    for(int i = 1; i <= n; i++) {
      for(int j=1; j<= partitionSum; j++) {
        if(j>=arr[i-1]) {
          dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
        } else {
          dp[i][j] = dp[i-1][j];
        }
      }
    }

    return dp[n][partitionSum];
  }
} 