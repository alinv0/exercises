package binarysearch;

// https://leetcode.com/problems/binary-search/
// 
// Given an array of integers nums which is sorted in ascending order, and an integer target, write
// a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
// You must write an algorithm with O(log n) runtime complexity.
public class BinarySearch {
  static class Solution {

    public int search(int[] nums, int target) {
      int left = 0;
      int right = nums.length - 1;
      while (left <= right) {
        int mid = left + (right - left) / 2;
        if (target == nums[mid]) {
          return mid;
        } else {
          if (target < nums[mid]) {
            right = mid - 1;
          } else if (target > nums[mid]) {
            left = mid + 1;
          }
        }
      }

      return -1;
    }
  }

  public static void main(String[] args) {
    var solution = new Solution();
    System.out.println(solution.search(new int[] {-1, 0, 3, 5, 9, 12}, 13));
  }
} 