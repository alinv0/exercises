package arrays;

// https://leetcode.com/problems/median-of-two-sorted-arrays/
// 
// Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the
// two sorted arrays. The overall run time complexity should be O(log (m+n)).

public class MedianOfTwoSortedArrays {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    if (nums1.length > nums2.length) {
      return findMedianSortedArrays(nums2, nums1);
    }
    int m = nums1.length;
    int n = nums2.length;
    int imin = 0, imax = m, halfLen = (m + n + 1) / 2;
    while (imin <= imax) {
      int i = (imin + imax) / 2;
      int j = halfLen - i;
      if (i < m && nums2[j - 1] > nums1[i]) {
        imin = i + 1;
      } else if (i > 0 && nums1[i - 1] > nums2[j]) {
        imax = i - 1;
      } else {
        int maxOfLeft;
        if (i == 0) { maxOfLeft = nums2[j - 1]; }
        else if (j == 0) { maxOfLeft = nums1[i - 1]; }
        else { maxOfLeft = Math.max(nums1[i - 1], nums2[j - 1]); }
        if ((m + n) % 2 == 1) {
          return maxOfLeft;
        }
        int minOfRight;
        if (i == m) { minOfRight = nums2[j]; }
        else if (j == n) { minOfRight = nums1[i]; }
        else { minOfRight = Math.min(nums1[i], nums2[j]); }
        return (maxOfLeft + minOfRight) / 2.0;
      }
    }
    throw new IllegalArgumentException("Input arrays are not sorted or invalid");
  }
} 