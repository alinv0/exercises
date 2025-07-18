package string;

// https://leetcode.com/problems/string-compression/
// 
// Given an array of characters chars, compress it using the following algorithm:
// Begin with an empty string s. For each group of consecutive repeating characters in chars:
// - If the group's length is 1, append the character to s.
// - Otherwise, append the character followed by the group's length.
// The compressed string s should not be returned separately, but instead be stored in the input 
// character array chars. Note that group lengths that are 10 or longer will be split into multiple 
// characters in chars.

public class StringCompression {
  static class Solution {
    public int compress(char[] chars) {
      if (chars.length <= 1) {
        return chars.length;
      }

      int charStart = 0;
      int charEnd = 0;
      int compressionIndex = 0;
      for (int i = 1; i <= chars.length; i++) {
        if (i < chars.length && chars[i] == chars[charStart]) {
          charEnd = i;
        } else {
          int count = charEnd - charStart + 1;
          chars[compressionIndex++] = chars[charStart];
          if (count > 1) {
            for (char c : String.valueOf(count).toCharArray()) {
              chars[compressionIndex++] = c;
            }
          }
          charStart = charEnd = i;
        }
      }
      return compressionIndex;
    }
  }

  public static void main(String[] args) {
    System.out.println(new Solution().compress(new char[] {'a', 'b', 'c'}));
//    System.out.println(new Solution().compress(new char[] {'a', 'a', 'a', 'b', 'b', 'a', 'a'}));
//    System.out.println(new Solution().compress(new char[] {'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
//    System.out.println(new Solution().compress(new char[] {'a'}));
//    System.out.println(
//        new Solution()
//            .compress(
//                new char[] {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}));
  }
}
