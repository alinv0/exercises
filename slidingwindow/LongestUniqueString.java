package slidingwindow;

//Given a string s, find the length of the longest substring without duplicate characters.
//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

import java.util.HashMap;
import java.util.Map;

public class LongestUniqueString {
  public static void main(String[] args){
    String s = "abcabcbb";
    System.out.println(lengthOfLongestSubstring(s));
  }

  public static int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> map = new HashMap<>();
    int maxLen = 0;
    int left = 0;
    for (int right = 0; right < s.length(); right++) {
      char c = s.charAt(right);
      if (map.containsKey(c) && map.get(c) >= left) {
        left = map.get(c) + 1;
      }
      map.put(c, right);
      maxLen = Math.max(maxLen, right - left + 1);
    }
    return maxLen;
  }
} 