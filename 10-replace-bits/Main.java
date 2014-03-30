// You are given two 32-bit numbers, N and M, and two bit positions, i and j. Write a method to set all bits between i and j in N equal to M (e.g., M becomes a substring of N located at i and starting at j).
public class Main {

  private static int replaceBits(int n, int m, int i, int j) {
    return n & (~((1 << i) - 1)^((1 << j) - 1)) |  m << i;
  }

  public static void main(String[] args) {
    int result = replaceBits(1024, 21, 2, 6); // n = 10000000000 m = 10101
    System.out.println("Result: " + Integer.toBinaryString(result));
  }

}
