// reverse the bits of a number. This assumes 64bit numbers.

public class Main {

  private static int reverse(int number) {
    int reversed = 0;
    for(int i = 0; i < 32; i++) {
       int bit = (number & (1 << i)) >>> i;
      reversed = reversed | (bit << (31-i));  
     }
    return reversed;
  }

  private static long reverseInPlace2(long number) {


    System.out.println("Number:  " + Long.toBinaryString(number));
    for(long i = 0; i < 32; i++) {
      System.out.println("I: " + i);
      
      long val1 = (number & (1 << i)) >>> i;
     System.out.println("val1:  " + Long.toBinaryString(val1));
     long val2 = (number & (1 << (63 - i))) >>> (63 - i);
    System.out.println("val2:  " + Long.toBinaryString(val2));

      number = number & ~(1 << i);
      number = number & ~(1 << (63 - i));
   System.out.println("After deletion:  " + Long.toBinaryString(number));

      number = number | (val1 << (63 - i));
      number = number | (val2 << i);
    System.out.println("Number:  " + Long.toBinaryString(number));

    }
    return number;
  }

  private static int reverseInPlace(int number) {

    for(int i = 0; i < 16; i++) {      

      int val1 = number & (1 << i);
      int val2 = number & (1 << (31 - i));

      number = number & ~(1 << i);
      number = number & ~(1 << (31 - i));

      int diff = 31 - i - i;
      number = number | (val1 << diff);
      number = number | (val2 >>> diff);      
    }
    return number;
  }



  public static void main(String[] args) {

    System.out.println("Should return 11: " + reverse(reverse(11)));
    System.out.println("Should return 11: " + reverseInPlace2(reverseInPlace2(11l)));
    System.out.println("Should return 11: " + reverseInPlace(reverseInPlace(11)));
  }

}
