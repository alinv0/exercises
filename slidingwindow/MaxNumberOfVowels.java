package slidingwindow;

// https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length

public class MaxNumberOfVowels {
  static class Solution {
    public int maxVowels(String s, int k) {
      int currentVowels = 0;

      for(int i=0; i<k; i++) {
        char c = s.charAt(i);
        if(isVowel(c)) {
          currentVowels++;
        }
      }
      int maxVowels = currentVowels;
      for(int i=k; i<s.length(); i++) {
        char c = s.charAt(i);
        char prev = s.charAt(i-k);

        if(isVowel(prev)) {
          currentVowels--;
        }

        if(isVowel(c)) {
          currentVowels++;
          maxVowels = Math.max(maxVowels, currentVowels);
        }
      }

      return maxVowels;
    }

    private boolean isVowel(char c) {
      return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
  }

  public static void main(String[] args){
    System.out.println(new Solution().maxVowels("abciiidef", 3));
    System.out.println(new Solution().maxVowels("weallloveyou", 7));
  }
}
