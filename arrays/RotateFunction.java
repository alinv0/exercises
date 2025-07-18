package arrays;

// https://leetcode.com/problems/rotate-function/
// 
// You are given an integer array nums of length n. Assume arrk to be an array obtained by rotating 
// nums by k positions clock-wise. We define the rotation function F on nums as follow:
// F(k) = 0 * arrk[0] + 1 * arrk[1] + ... + (n - 1) * arrk[n - 1].
// Return the maximum value of F(0), F(1), ..., F(n-1).

public class RotateFunction {
    static class Solution {
        public int maxRotateFunction(int[] nums) {
            int n = nums.length;
            if (n == 0) return 0;
            
            // Calculate the initial sum and the sum of all elements
            long sum = 0;
            long initialF = 0;
            
            for (int i = 0; i < n; i++) {
                sum += nums[i];
                initialF += i * nums[i];
            }
            
            long maxF = initialF;
            long currentF = initialF;
            
            // For each rotation, we can calculate the new F value using the formula:
            // F(k+1) = F(k) + sum - n * nums[n-1-k]
            // This is because when we rotate, we subtract the contribution of the last element
            // and add the contribution of the new first element
            for (int k = 1; k < n; k++) {
                currentF = currentF + sum - n * nums[n - k];
                maxF = Math.max(maxF, currentF);
            }
            
            return (int) maxF;
        }
        
        /**
         * Alternative approach using mathematical derivation:
         * 
         * F(0) = 0*a[0] + 1*a[1] + 2*a[2] + ... + (n-1)*a[n-1]
         * F(1) = 0*a[n-1] + 1*a[0] + 2*a[1] + ... + (n-1)*a[n-2]
         * F(2) = 0*a[n-2] + 1*a[n-1] + 2*a[0] + ... + (n-1)*a[n-3]
         * 
         * We can see that:
         * F(1) = F(0) + sum - n*a[n-1]
         * F(2) = F(1) + sum - n*a[n-2]
         * F(k) = F(k-1) + sum - n*a[n-k]
         */
        public int maxRotateFunctionOptimized(int[] nums) {
            int n = nums.length;
            if (n == 0) return 0;
            
            long sum = 0;
            long f0 = 0;
            
            for (int i = 0; i < n; i++) {
                sum += nums[i];
                f0 += i * nums[i];
            }
            
            long maxF = f0;
            long prevF = f0;
            
            for (int i = 1; i < n; i++) {
                long currentF = prevF + sum - n * nums[n - i];
                maxF = Math.max(maxF, currentF);
                prevF = currentF;
            }
            
            return (int) maxF;
        }
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1: [4,3,2,6] -> 26
        int[] nums1 = {4, 3, 2, 6};
        System.out.println("Test 1: " + solution.maxRotateFunction(nums1)); // Expected: 26
        
        // Test case 2: [100] -> 0
        int[] nums2 = {100};
        System.out.println("Test 2: " + solution.maxRotateFunction(nums2)); // Expected: 0
        
        // Test case 3: [1,2,3,4,5,6,7,8,9,10] -> 330
        int[] nums3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Test 3: " + solution.maxRotateFunction(nums3)); // Expected: 330
        
        // Test case 4: [1,2,3,4] -> 20
        int[] nums4 = {1, 2, 3, 4};
        System.out.println("Test 4: " + solution.maxRotateFunction(nums4)); // Expected: 20
        
        // Test case 5: [0,0,0,0] -> 0
        int[] nums5 = {0, 0, 0, 0};
        System.out.println("Test 5: " + solution.maxRotateFunction(nums5)); // Expected: 0
    }
} 