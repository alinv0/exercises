package bitmanipulation;

/**
 * Count the number of bits that are set to 1 in an integer
 */
public class CountBits {

  public static short countBits(int x) {
    short numBits = 0;
    while(x != 0) {
      numBits += (x & 1);
      x >>>= 1;
    }

    return numBits;
  }

  public static void main(String[] args) {
    int x = 0b10101010101010101010101010101111;
    System.out.println(countBits(x));
  }
} 