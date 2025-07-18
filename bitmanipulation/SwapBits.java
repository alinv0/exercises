package bitmanipulation;

/**
 * Swap a pair of bits.
 */
public class SwapBits {

  public static long swapBits(long x, int i, int j) {
    if (((x >>> i) & 1) != ((x >>> j) & 1)) {
      long bitMask = (1L << i) | (1L << j);
      x ^= bitMask;
    }

    return x;
  }

  public static void main(String[] args){
    long x = 0b10101010101011111010101010101110;
    int i = 1;
    int j = 3;
    System.out.println(Long.toBinaryString(1L << i));
    System.out.println(Long.toBinaryString(1L << j));
    System.out.println(Long.toBinaryString(1L << i | 1L << j));
    System.out.println(Long.toBinaryString(x));
    System.out.println(Long.toBinaryString(swapBits(x, i, j)));
  }
} 