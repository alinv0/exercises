package slidingwindow;

// https://leetcode.com/problems/maximum-average-subarray-i

public class MaxAvgSubarray {
  static class Solution {
    public double findMaxAverage(int[] nums, int k) {
      double sum = 0;
      for(int i=0; i<k; i++) {
        sum += nums[i];
      }
      double maxSum = sum;
      for(int i=k; i<nums.length; i++) {
        //sliding window (subtracts the first element and adds the next one)
        sum = sum + nums[i] - nums[i-k];
        maxSum = Math.max(maxSum, sum);
      }
      return maxSum / k;
    }
  }

  public static void main(String[] args){
    System.out.println(
        new Solution().findMaxAverage(new int[] {1, 12, -5, -6, 50, 3}, 4)
    );
    System.out.println(
        new Solution().findMaxAverage(new int[] {5}, 1)
    );
    System.out.println(
        new Solution().findMaxAverage(new int[] {-1}, 1)
    );
  }
}
