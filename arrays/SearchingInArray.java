package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchingInArray {
  static class Solution {
    public int search(int k, ArrayList<Integer> arr) {
      for (int i = 0; i < arr.size(); i++) {
        if (arr.get(i).equals(k)) {
          return i+1;
        }
      }
      return -1;
    }
  }

  public static void main(String[] args){
    var arr = new ArrayList<>(Arrays.asList(9, 7, 2, 16, 4));
    System.out.println(new Solution().search(16, arr));
  }
} 