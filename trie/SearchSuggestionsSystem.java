package trie;

// https://leetcode.com/problems/search-suggestions-system

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionsSystem {
  static class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
      Arrays.sort(products);
      List<List<String>> results = new ArrayList<>();
      StringBuilder prefix = new  StringBuilder();
      int n = products.length;
      int left = 0;
      int right = n - 1;
      for (char c : searchWord.toCharArray()) {
        prefix.append(c);
        // Move left to the first product >= prefix
        while (left <= right &&
            (products[left].length() < prefix.length() ||
            !products[left].startsWith(prefix.toString()))) {
          left++;
        }
        // Move right to the last product <= prefix + 'z...'
        while (left <= right && (products[right].length() < prefix.length() ||
            !products[right].startsWith(prefix.toString()))) {
          right--;
        }
        List<String> prefixResults = new ArrayList<>();
        for (int i = left; i <= right && i < left + 3; i++) {
          prefixResults.add(products[i]);
        }
        results.add(prefixResults);
      }
      return results;
    }
  }

  public static void main(String[] args){
    System.out.println(new Solution().suggestedProducts(
        new String[] {"mobile","mouse","moneypot","monitor","mousepad"},
        "mouse"));
  }
}
