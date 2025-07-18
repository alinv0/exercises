package string;

/**
 * https://www.hackerrank.com/challenges/repeated-string/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup
 */
public class RepeatedString {
  public static void main(String[] args){
    System.out.println(repeatedString("abcac", 20));
  }

  public static long repeatedString(String s, long n) {
    long total = n/s.length() * noCharsInString(s, 'a')
        + noCharsInString(s.substring(0, (int)(n%s.length())), 'a');

    return total;
  }

  private static int noCharsInString(String s, Character c) {
    if(s.lastIndexOf(c) < 0) {
      return 0;
    }

    var count = 0;
    for(int i=0; i<s.length(); i++) {
      if(c == s.charAt(i)) {
        count++;
      }
    }

    return count;
  }
} 