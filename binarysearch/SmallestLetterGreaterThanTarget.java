package binarysearch;

// https://leetcode.com/problems/find-smallest-letter-greater-than-target/
// 
// You are given an array of characters letters that is sorted in non-decreasing order, and a
// character target. Return the smallest character in letters that is lexicographically greater 
// than target. If such a character does not exist, return the first character in letters.
public class SmallestLetterGreaterThanTarget {
  static class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
      int left = 0;
      int right = letters.length - 1;
      
      while (left <= right) {
        int mid = left + (right - left) / 2;
        if (letters[mid] <= target) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
      
      return letters[left % letters.length];
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.nextGreatestLetter(new char[] {'z', 'z', 'z'}, 'z'));
    System.out.println(solution.nextGreatestLetter(new char[] {'c', 'f', 'j'}, 'z'));
    System.out.println(solution.nextGreatestLetter(new char[] {'c', 'f', 'j'}, 'a'));
    System.out.println(solution.nextGreatestLetter(new char[] {'c', 'f', 'j'}, 'c'));
  }
} 