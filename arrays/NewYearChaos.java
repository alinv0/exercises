package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://www.hackerrank.com/challenges/new-year-chaos/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 */
public class NewYearChaos {

  public static void main(String[] args){
    minimumBribes(Arrays.asList(1,2,3,4,5,6,7,8));
    minimumBribes(Arrays.asList(2,1,3,5,4,8,7,6));
  }
  
  public static void minimumBribes(List<Integer> q) {
    int n = q.size(); // Number of people in the queue
    int bribes = 0;
    boolean chaotic = false;

    for (int i = 0; i < n; i++) {
      int originalPosition = q.get(i) - 1;

      // Check if the person moved more than 2 positions forward
      if (originalPosition - i > 2) {
        chaotic = true;
        break;
      }

      // Count the number of bribes each person made
      for (int j = Math.max(0, originalPosition - 1); j < i; j++) {
        if (q.get(j) > q.get(i)) {
          bribes++;
        }
      }
    }
    
    if (chaotic) {
      System.out.println("Too chaotic");
    } else {
      System.out.println(bribes);
    }
  }
} 