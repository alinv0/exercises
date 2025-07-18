package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Subset Sum Problem using Backtracking
 * 
 * Given an array of integers and a target sum, find all subsets that sum to the target.
 * This demonstrates the core backtracking pattern.
 */
public class SubsetSum {
    static class Solution {
        public List<List<Integer>> findSubsets(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();
            backtrack(nums, target, 0, 0, new ArrayList<>(), result);
            return result;
        }
        
        private void backtrack(
            int[] nums,           // Input array
            int target,           // Target sum
            int currentSum,       // Current sum so far
            int start,            // Starting index (avoid duplicates)
            List<Integer> path,   // Current subset being built
            List<List<Integer>> result  // All valid subsets
        ) {
            // Base case 1: Found a valid subset
            if (currentSum == target) {
                result.add(new ArrayList<>(path));
                return;
            }
            
            // Base case 2: Sum exceeded target
            if (currentSum > target) {
                return;
            }
            
            // Try all possible choices from current position
            for (int i = start; i < nums.length; i++) {
                // Choose: Add current number to subset
                path.add(nums[i]);
                
                // Explore: Recursively try with this choice
                backtrack(nums, target, currentSum + nums[i], i + 1, path, result);
                
                // Unchoose: Remove the number to try other options
                path.remove(path.size() - 1);
            }
        }
        
        /**
         * Alternative approach: Include/Exclude each element
         * This shows another common backtracking pattern
         */
        public List<List<Integer>> findSubsetsIncludeExclude(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();
            backtrackIncludeExclude(nums, target, 0, 0, new ArrayList<>(), result);
            return result;
        }
        
        private void backtrackIncludeExclude(
            int[] nums,
            int target,
            int currentSum,
            int index,
            List<Integer> path,
            List<List<Integer>> result
        ) {
            // Base case: processed all elements
            if (index == nums.length) {
                if (currentSum == target) {
                    result.add(new ArrayList<>(path));
                }
                return;
            }
            
            // Choice 1: Include current element
            path.add(nums[index]);
            backtrackIncludeExclude(nums, target, currentSum + nums[index], index + 1, path, result);
            path.remove(path.size() - 1);  // backtrack
            
            // Choice 2: Exclude current element
            backtrackIncludeExclude(nums, target, currentSum, index + 1, path, result);
        }
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1: [1, 2, 3, 4], target = 5
        int[] nums1 = {1, 2, 3, 4};
        System.out.println("Subsets that sum to 5:");
        List<List<Integer>> result1 = solution.findSubsets(nums1, 5);
        for (List<Integer> subset : result1) {
            System.out.println(subset);
        }
        
        System.out.println("\nUsing include/exclude approach:");
        List<List<Integer>> result2 = solution.findSubsetsIncludeExclude(nums1, 5);
        for (List<Integer> subset : result2) {
            System.out.println(subset);
        }
        
        // Test case 2: [2, 3, 6, 7], target = 7
        System.out.println("\nSubsets that sum to 7 from [2, 3, 6, 7]:");
        int[] nums2 = {2, 3, 6, 7};
        List<List<Integer>> result3 = solution.findSubsets(nums2, 7);
        for (List<Integer> subset : result3) {
            System.out.println(subset);
        }
    }
} 