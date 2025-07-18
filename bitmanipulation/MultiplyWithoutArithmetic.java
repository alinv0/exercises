package bitmanipulation;

/**
 * COMPUTE X * Y WITHOUT ARITHMETICAL OPERATORS
 */
public class MultiplyWithoutArithmetic {

  public static int times_brute_force(int x, int y) {
    int sum = 0;
    for(int i=0; i<y; i++) {
      sum += x;
    }

    return sum;
  }

  public static long times_bit_shifting(long x, long y) {
    long sum = 0;
    while(x != 0) {
      if((x & 1) != 0) {
        sum = add(sum, y);
      }
      x >>= 1;
      y <<= 1;
    }
    return sum;
  }

  public static long add(long a, long b) {
    long sum = 0;
    long carryin = 0;
    long k = 1;
    long tempA = a;
    long tempB = b;
    while (tempA != 0 || tempB != 0) {
      long ak = a & k;
      long bk = b & k;
      long carryout = (ak & bk) | (ak & carryin) | (bk & carryin);
      sum |= (ak ^ bk ^ carryin);
      carryin = carryout << 1;
      tempA >>= 1;
      tempB >>= 1;
      k <<= 1;
    }

    return sum | carryin;
  }

  public static void main(String[] args){
    int x = 5;
    int y = 6;
    System.out.println("Brute force: " + times_brute_force(x, y));
    System.out.println("Bit shifting: " + times_bit_shifting(x, y));
  }
} 