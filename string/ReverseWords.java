package string;

// https://leetcode.com/problems/reverse-words-in-a-string/
// 
// Given an input string s, reverse the order of the words. A word is defined as a sequence of 
// non-space characters. The words in s will be separated by at least one space. Return a string 
// of the words in reverse order concatenated by a single space.

public class ReverseWords {
  static class Solution {
    public String reverseWords(String s) {
      // Trim the input to remove leading and trailing spaces
      s = s.trim();
      
      // Convert the string to a character array
      char[] chars = s.toCharArray();
      
      // Reverse the entire string
      reverse(chars, 0, chars.length - 1);
      
      // Reverse each word in the reversed string
      int start = 0;
      for (int end = 0; end < chars.length; end++) {
        if (chars[end] == ' ') {
          reverse(chars, start, end - 1);
          start = end + 1;
        }
      }
      // Reverse the last word
      reverse(chars, start, chars.length - 1);
      
      // Convert the character array back to a string and split by spaces
      return new String(chars).replaceAll("\\s+", " ");
    }
    
    private void reverse(char[] chars, int left, int right) {
      while (left < right) {
        char temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;
        left++;
        right--;
      }
    }
  }

  public static void main(String[] args) {
    System.out.println(new Solution().reverseWords("the sky is blue"));
    System.out.println(new Solution().reverseWords("  hello world  "));
    System.out.println(new Solution().reverseWords("a good   example"));
  }
}
