package bitmanipulation;

/**
 * The parity of a binary word is 1 if the number of Is in the word is odd; otherwise,
 * it is 0. Parity checks are used to detect single bit errors in data storage
 * and communication. Write code that computes the parity of a single 64-bit word.
 */
public class Parity {

  public static short parity_brute_force(long x) {
    short result = 0;
    while(x != 0) {
      result ^= (x & 1);
      x >>>= 1;
    }

    return result;
  }

  public static short parity_optimized(long x) {
    short result = 0;
    while(x != 0) {
      result ^= 1;
      x &= (x - 1);
    }

    return result;
  }

  public static short parity_lookup_table(long x) {
    x ^= x >>> 32;
    x ^= x >>> 16;
    x ^= x >>> 8;
    x ^= x >>> 4;
    x ^= x >>> 2;
    x ^= x >>> 1;

    return (short)(x & 0x1);
  }

  public static void main(String[] args){
    long x = 0b10101010101011111010101010101110;
    System.out.println(parity_brute_force(x));
    System.out.println(parity_optimized(x));
    System.out.println(parity_lookup_table(x));
  }
} 