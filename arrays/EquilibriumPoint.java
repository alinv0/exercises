package arrays;

// https://www.geeksforgeeks.org/problems/equilibrium-point-1587115620/1

import java.util.Arrays;

public class EquilibriumPoint {
  static class Solution {
    public static int findEquilibrium(int arr[]) {
      if (arr == null || arr.length < 3) {
        return -1;
      }
      
      // Calculate total sum once
      int totalSum = 0;
      for (int num : arr) {
        totalSum += num;
      }
      
      // Keep track of left sum as we iterate
      int leftSum = 0;
      
      // Start from index 1 since equilibrium point can't be at index 0 or last index
      for (int i = 1; i < arr.length - 1; i++) {
        leftSum += arr[i - 1];  // Add the previous element to left sum
        
        // Right sum = total - left sum - current element
        int rightSum = totalSum - leftSum - arr[i];
        
        if (leftSum == rightSum) {
          return i;
        }
      }

      return -1;
    }
  }

  public static void main(String[] args){
    // Test with some sample arrays
    int[] arr1 = {1, 3, 5, 2, 2};  // Expected: index 2 (element 5)
    int[] arr2 = {1, 2, 3, 4, 6};  // Expected: index 3 (element 4)
    int[] arr3 = {1, 2, 3};        // Expected: -1 (no equilibrium)
    
    System.out.println("Array: " + Arrays.toString(arr1) + " -> Equilibrium at index: " + Solution.findEquilibrium(arr1));
    System.out.println("Array: " + Arrays.toString(arr2) + " -> Equilibrium at index: " + Solution.findEquilibrium(arr2));
    System.out.println("Array: " + Arrays.toString(arr3) + " -> Equilibrium at index: " + Solution.findEquilibrium(arr3));
  }
} 