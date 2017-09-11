// Given n light bulbs, write two methods.
//isOn(i) to determine if a light bulb is on
//toggle(start, end) to toggle all the light bulbs in the range
//One caveat, write toggle so that it is less than O(n) complexity


public class Main {

  static int bulbs = Integer.parseInt("100100111001", 2);

  private static boolean isOn(int i) {
    int mask = 1 << i;
    return (bulbs & mask) > 0;
  }

  private static int toggle(int start, int end) {
    bulbs = bulbs ^ ((~0 << (end + 1)) ^ (~0 << start));

    // or
    // bulbs = bulbs ^ (((1 << (end + 1)) - 1) ^ ((1 << start) - 1));

    return bulbs;
  }

  public static void main(String[] args) {
    System.out.println("Original bulbs: " + Integer.toBinaryString(bulbs) + ", is on 5? " + isOn(5));
    System.out.println("Original bulbs: " + Integer.toBinaryString(bulbs) + ", is on 6? " + isOn(6));
    System.out.println("After toggling from 3 to 6: " + Integer.toBinaryString(toggle(3,6)));
  }

}
