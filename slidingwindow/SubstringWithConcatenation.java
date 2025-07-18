package slidingwindow;

// https://leetcode.com/problems/substring-with-concatenation-of-all-words

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenation {
  static class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
      List<Integer> result = new ArrayList<>();

      if (s == null || s.isEmpty() || words == null || words.length == 0) {
        return result;
      }

      int wordLength = words[0].length();
      int totalWords = words.length;
      int totalLength = wordLength * totalWords;

      if (s.length() < totalLength) {
        return result;
      }

      // Count frequency of each word
      Map<String, Integer> wordCount = new HashMap<>();
      for (String word : words) {
        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
      }

      // Try each possible starting position (0 to wordLength-1)
      for (int i = 0; i < wordLength; i++) {
        findSubstringsStartingAt(s, i, wordLength, totalWords, wordCount, result);
      }

      return result;
    }

    private void findSubstringsStartingAt(String s, int start, int wordLength, int totalWords,
                                        Map<String, Integer> wordCount,
                                        List<Integer> result) {
      Map<String, Integer> currentCount = new HashMap<>();
      int left = start;
      int wordsUsed = 0;

      for (int right = start; right <= s.length() - wordLength; right += wordLength) {
        String word = s.substring(right, right + wordLength);

        if (!wordCount.containsKey(word)) {
          // Word not in our list, reset window
          currentCount.clear();
          wordsUsed = 0;
          left = right + wordLength;
          continue;
        }

        // Add current word to our window
        currentCount.put(word, currentCount.getOrDefault(word, 0) + 1);
        wordsUsed++;

        // If we have too many of this word, shrink window from left
        while (currentCount.get(word) > wordCount.get(word)) {
          String leftWord = s.substring(left, left + wordLength);
          currentCount.put(leftWord, currentCount.get(leftWord) - 1);
          wordsUsed--;
          left += wordLength;
        }

        // If we have exactly the right number of words, we found a match
        if (wordsUsed == totalWords) {
          result.add(left);

          // Move left pointer to continue searching
          String leftWord = s.substring(left, left + wordLength);
          currentCount.put(leftWord, currentCount.get(leftWord) - 1);
          wordsUsed--;
          left += wordLength;
        }
      }
    }
  }

  public static void main(String[] args){
    Solution solution = new Solution();

    // Test case 1: Basic example
    String s1 = "barfoothefoobarman";
    String[] words1 = {"foo","bar"};
    System.out.println("Test 1: " + solution.findSubstring(s1, words1)); // Expected: [0, 9]

    // Test case 2: No valid concatenation
    String s2 = "wordgoodgoodgoodbestword";
    String[] words2 = {"word","good","best","good"};
    System.out.println("Test 2: " + solution.findSubstring(s2, words2)); // Expected: []

    // Test case 3: Multiple valid positions
    String s3 = "barfoobar";
    String[] words3 = {"foo","bar"};
    System.out.println("Test 3: " + solution.findSubstring(s3, words3)); // Expected: [0, 3]

    // Test case 4: Single word
    String s4 = "aaaa";
    String[] words4 = {"aa","aa"};
    System.out.println("Test 4: " + solution.findSubstring(s4, words4)); // Expected: [0, 1, 2]
  }
} 