package binarysearch;

// https://leetcode.com/problems/find-peak-element

public class FindPeakElement {
  static class Solution {
    private boolean checkNeighbours(int index, int[] nums) {
      return nums[index] > nums[index-1] && nums[index] > nums[index+1];
    }

    public int findPeakElement(int[] nums) {
      int left = 0;
      int right = nums.length - 1;

      if(nums.length == 1) {
        return 0;
      }

      while (left <= right) {
        if(left == 0) {
          if(nums[left+1] < nums[left]) {
            return left;
          }
        } else {
          if(checkNeighbours(left, nums)) {
            return left;
          }
        }

        if(right == nums.length-1) {
          if(nums[right-1] < nums[right] ){
            return right;
          }
        } else {
          if(checkNeighbours(right, nums)) {
            return right;
          }
        }

        left ++;
        right --;
      }

      return -1;
    }
  }

  public static void main(String[] args) {
    System.out.println(new Solution().findPeakElement(new int[] {1, 2, 3, 1}));
    System.out.println(new Solution().findPeakElement(new int[] {1, 2, 1, 3, 5, 6, 4}));
    System.out.println(new Solution().findPeakElement(new int[] {3, 2, 1}));
  }
}
