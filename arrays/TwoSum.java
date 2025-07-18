package arrays;

// https://leetcode.com/problems/two-sum/
// 
// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
// You can return the answer in any order.

public class TwoSum {
  public static int[] twoSum(int[] nums, int target) {
    for(int i=0; i<nums.length; i++) {
      for(int j=i+1; j<nums.length; j++) {
        if(nums[i] + nums[j] == target) {
          return new int[] {i, j};
        }
      }
    }
    return new int[] {-1, -1};
  }

  public static void main(String[] args){
    int[] result1 = TwoSum.twoSum(new int[] {2,7,11,15}, 9);
    System.out.println(result1[0] + " - " + result1[1]);

    int[] result2 = TwoSum.twoSum(new int[] {3,2,4}, 6);
    System.out.println(result2[0] + " - " + result2[1]);
  }
} 