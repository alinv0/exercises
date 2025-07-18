package bitmanipulation;

/**
 * Reverse the bits of a number
 */
public class ReverseBits {
  private static final int[] REVERSE_TABLE = new int[256];

  static {
    for (int i = 0; i < 256; i++) {
      REVERSE_TABLE[i] = (reverseByte((byte) i) << 24);
    }
  }

  public static long reverseBits_lookup(long n) {
    return (REVERSE_TABLE[(int) (n & 0xFF)] |
        REVERSE_TABLE[(int) ((n >> 8) & 0xFF)] |
        REVERSE_TABLE[(int) ((n >> 16) & 0xFF)] |
        REVERSE_TABLE[(int) ((n >> 24) & 0xFF)] |
        REVERSE_TABLE[(int) ((n >> 32) & 0xFF)] |
        REVERSE_TABLE[(int) ((n >> 40) & 0xFF)] |
        REVERSE_TABLE[(int) ((n >> 48) & 0xFF)] |
        REVERSE_TABLE[(int) ((n >> 56) & 0xFF)]);
  }

  private static int reverseByte(byte b) {
    int result = 0;
    for (int i = 0; i < 8; i++) {
      result = (result << 1) | ((b >> i) & 1);
    }
    return result;
  }

  public static long reverseBits(long n) {
    long reversed = 0;
    int bitCount = 64; // 64 bits in a long

    for (int i = 0; i < bitCount; i++) {
      // Shift the reversed value to the left to make space for the next bit
      reversed <<= 1;

      // Extract the least significant bit of 'n' and set it as the current bit in 'reversed'
      reversed |= (n & 1);

      // Right-shift 'n' to consider the next bit
      n >>= 1;
    }

    return reversed;
  }

  public static void main(String[] args) {
    long original = 123456789; // Example input
    long reversed = reverseBits(original);
    System.out.println("Original: " + Long.toBinaryString(original));
    System.out.println("Reversed: " + Long.toBinaryString(reversed));
  }
} 