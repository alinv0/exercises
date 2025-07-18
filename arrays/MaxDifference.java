package arrays;

// https://www.naukri.com/code360/problems/maximum-distance_1170523

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MaxDifference {
  static class Solution {
    public int maxDiff(ArrayList<Integer> a, int n) {
      if (n <= 1) return -1;
      
      int maxDiff = -1;
      int minElement = a.get(0);
      
      for (int i = 1; i < n; i++) {
        if (a.get(i) > minElement) {
          maxDiff = Math.max(maxDiff, a.get(i) - minElement);
        } else {
          minElement = Math.min(minElement, a.get(i));
        }
      }
      
      return maxDiff;
    }
  }
  
  public static void main(String[] args) {
    Solution solution = new Solution();
    ArrayList<Integer> arr = new ArrayList<>();
    arr.add(2);
    arr.add(3);
    arr.add(10);
    arr.add(6);
    arr.add(4);
    arr.add(8);
    arr.add(1);
    
    System.out.println(solution.maxDiff(arr, arr.size()));
  }
} 